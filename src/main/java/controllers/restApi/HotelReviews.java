package controllers.restApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.IOUtils;
import storage.hotelReview.HotelReview;
import storage.hotelReview.HotelReviewInstance;
import utils.SplitQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/restApi/hotelReviews")
public class HotelReviews extends HttpServlet {

    private static final String SUCCESSFULLY = "{\"successfully\":\"Successfully\"}";
    private static final String ARG_ERROR = "{\"error\":\"No arguments\"}";
    private static final String UNKNOWN_ERROR = "{\"error\":\"Unknown error, try again later\"}";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String resault = "";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        if(req.getParameterMap().containsKey("idUser")){
            int id = Integer.parseInt(req.getParameter("idUser"));
            Set<HotelReview> hotelReviews = HotelReviewInstance.getHotelReviewInstance().getHotelReviewByUserId(id);
            resault = objectMapper.writeValueAsString(hotelReviews);
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

        String body = IOUtils.toString(req.getReader());
        Map<String, List<String>> map = SplitQuery.split(body);

        try{
            storage.hotelReview.HotelReview hotelReview = HotelReview.HotelReviewBuilder.aHotelReview()
                    .withId(Integer.parseInt(map.get("idComment").get(0)))
                    .withDateOfVisit(map.get("dateOfVisit").get(0))
                    .withRating(Integer.parseInt(map.get("rating").get(0)))
                    .withDescription(map.get("description").get(0))
                    .build();

            if (HotelReviewInstance.getHotelReviewInstance().updateHotelReviewById(hotelReview)){
                resp.getWriter().print(SUCCESSFULLY);
            }
            else {
                resp.setStatus(300);
                resp.getWriter().print(UNKNOWN_ERROR);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            resp.setStatus(300);
            resp.getWriter().print(ARG_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        super.doDelete(req, resp);
    }
}
