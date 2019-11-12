package controllers;

import storage.hotel.Hotel;
import storage.hotel.HotelInstance;
import storage.hotelReview.HotelReview;
import storage.hotelReview.HotelReviewInstance;
import utils.FreeMarker;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/HotelCard")
public class HotelCard extends HttpServlet {

    public static final String KEY_HOTEL = "hotel";
    public static final String KEY_COMMENTS = "comments";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_HOTEL_CARD, webAddress, this);

        if (req.getParameterMap().containsKey("id")){

            int id = Integer.parseInt(req.getParameter("id"));
            Hotel hotel = HotelInstance.getHotelInstance().getHotelById(id);

            if (hotel != null){
                freeMarker.putVal(KEY_HOTEL, hotel);

                ArrayList<HotelReview> hotelReview = HotelReviewInstance.getHotelReviewInstance().getHotelReviewByHotelId(hotel.getId());
                freeMarker.putList(KEY_COMMENTS, hotelReview);
            }
            else {
                resp.getWriter().println("No hotel " + id);
            }
        }
        else{
            resp.getWriter().println("No id");
        }

        resp.getWriter().println(freeMarker);
        resp.setContentType("text/html");
    }
}

