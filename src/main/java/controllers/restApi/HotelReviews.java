package controllers.restApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import storage.hotelReview.HotelReview;
import storage.hotelReview.HotelReviewInstance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = "/restApi/hotelReviews")
public class HotelReviews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String resault = "";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        if(req.getParameterMap().containsKey("idUser")){
            int id = Integer.parseInt(req.getParameter("id"));
        }
        else if (req.getParameterMap().containsKey("idHotel")){
            int id = Integer.parseInt(req.getParameter("idHotel"));
            Set<HotelReview> hotelReviews = HotelReviewInstance.getHotelReviewInstance().getHotelReviewByHotelId(id);
            resault = objectMapper.writeValueAsString(hotelReviews);
        }

        resp.getWriter().print(resault);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        super.doDelete(req, resp);
    }
}
