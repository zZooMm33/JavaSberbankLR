package controllers;

import storage.hotel.Hotel;
import storage.hotel.HotelInstance;
import utils.FreeMarker;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/")
public class Index extends HttpServlet {

    /**
     * Переменная (для ftl) в которую будет записан список отелей
     */
    public static final String KEY_HOTEL_LIST = "hotels";

    /**
     * Метод Get для сервлета
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_INDEX, webAddress, this);
        ArrayList<Hotel> hotels = HotelInstance.getHotelInstance().getAllHotels();

        freeMarker.putList(KEY_HOTEL_LIST, hotels);

        resp.getWriter().println(freeMarker);
        resp.setContentType("text/html");
    }
}

