package controllers.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import storage.hotel.Hotel;
import utils.FreeMarker;
import utils.Request;
import utils.Session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = "/")
public class Index extends HttpServlet {

    /**
     * Переменная (для ftl) в которую будет записан список отелей
     */
    public static final String KEY_HOTEL_LIST = "hotels";

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
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_INDEX, webAddress, this);
        Set<Hotel> hotels = null;

        try {
            String commJson= Request.sendGetRequest(webAddress+"/restApi/hotels");
            ObjectMapper mapper = new ObjectMapper();
            hotels = mapper.readValue(commJson, new TypeReference<Set<Hotel>>(){});
        }
        catch (Exception e){
            e.printStackTrace();
        }

        freeMarker.putList(KEY_HOTEL_LIST, hotels);

        String token = Session.getFromSession(req, Session.KEY_TOKEN_STRING);
        freeMarker.putString(FreeMarker.KEY_TOKEN, token);

        resp.getWriter().println(freeMarker);
        resp.setContentType("text/html");
    }
}

