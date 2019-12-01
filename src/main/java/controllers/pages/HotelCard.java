package controllers.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import storage.hotel.Hotel;
import storage.hotelReview.HotelReview;
import utils.FreeMarker;
import utils.Request;
import utils.Session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Сервлет для отображения информации о отеле  и его комментариях
 */
@WebServlet(urlPatterns = "/HotelCard")
public class HotelCard extends HttpServlet {

    /**
     * Переменная (для ftl) в которую будет записана информация об отеле
     */
    public static final String KEY_HOTEL = "hotel";

    /**
     * Метод Get для сервлета
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_HOTEL_CARD, webAddress, this);

        String token = Session.getFromSession(req, Session.KEY_TOKEN_STRING);
        freeMarker.putString(FreeMarker.KEY_TOKEN, token);

        if (req.getParameterMap().containsKey("id")) {

            int id = Integer.parseInt(req.getParameter("id"));
            Hotel hotel = null;

            try {
                String commJson= Request.sendGetRequest(webAddress+"/restApi/hotels?id=" + id);
                ObjectMapper mapper = new ObjectMapper();
                hotel = mapper.readValue(commJson, Hotel.class);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            if (hotel != null) {
                freeMarker.putVal(KEY_HOTEL, hotel);

                try {
                    String commJson= Request.sendGetRequest(webAddress+"/restApi/hotelReviews?idHotel=" + id);
                    ObjectMapper mapper = new ObjectMapper();
                    hotel.setHotelReview(mapper.readValue(commJson, new TypeReference<Set<HotelReview>>(){}));
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                resp.getWriter().println(freeMarker);
            } else {
                //Отеля с заданным id нет в БД
                resp.getWriter().println(FreeMarker.generateErrorPage("Hotel not found", webAddress, this));
            }
        } else {
            // не найден id в url
            resp.getWriter().println(FreeMarker.generateErrorPage("Error in request", webAddress, this));
        }

        resp.setContentType("text/html");
    }
}

