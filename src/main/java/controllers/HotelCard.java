package controllers;

import storage.hotel.Hotel;
import storage.hotel.HotelInstance;
import storage.hotelReview.HotelReviewInstance;
import utils.FreeMarker;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        if (req.getParameterMap().containsKey("id")) {

            int id = Integer.parseInt(req.getParameter("id"));
            Hotel hotel = HotelInstance.getHotelInstance().getHotelById(id);

            if (hotel != null) {
                freeMarker.putVal(KEY_HOTEL, hotel);
                hotel.setHotelReview(HotelReviewInstance.getHotelReviewInstance().getHotelReviewByHotelId(hotel.getId()));
                resp.getWriter().println(freeMarker);
            } else {
                //Отеля нет с заданным id нет в БД
                resp.getWriter().println(FreeMarker.generateErrorPage("Hotel not found", webAddress, this));
            }
        } else {
            // не найден id в url
            resp.getWriter().println(FreeMarker.generateErrorPage("Error in request", webAddress, this));
        }

        resp.setContentType("text/html");
    }
}

