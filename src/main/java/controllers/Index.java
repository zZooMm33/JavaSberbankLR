package controllers;

import storage.hotel.Hotel;
import storage.hotel.HotelInstance;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();

        String hotels = "";
        for(Hotel item : HotelInstance.getHotelInstance().getAllHotels()){
            hotels += "id: " + item.getId() + "<br>";
            hotels += "name: " + item.getName() + "<br>";
            hotels += "description: " + item.getDescription() + "<br>";
            hotels += "country: " + item.getCountry() + "<br>";
            hotels += "city: " + item.getCity() + "<br>";
            hotels += "star: " + item.getStar() + "<br>";
            hotels += "website: " + item.getWebsite() + "<br>";
            hotels += "<br>";
            hotels += "<br>";
        }

        resp.getWriter().println(hotels);

        resp.setContentType("text/html");
    }


}

