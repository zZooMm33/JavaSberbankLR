package controllers.restApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.IOUtils;
import storage.hotel.Hotel;
import storage.hotel.HotelInstance;
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

@WebServlet(urlPatterns = "/restApi/hotels")
public class Hotels extends HttpServlet {

    private static final String SUCCESSFULLY = "{\"successfully\":\"Successfully\"}";
    private static final String ARG_ERROR = "{\"error\":\"No arguments\"}";
    private static final String UNKNOWN_ERROR = "{\"error\":\"Unknown error, try again later\"}";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String resault;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        if(req.getParameterMap().containsKey("id")){
            int id = Integer.parseInt(req.getParameter("id"));
            Hotel hotel = HotelInstance.getHotelInstance().getHotelById(id);
            resault = objectMapper.writeValueAsString(hotel);
        }
        else {
            Set<Hotel> hotels = HotelInstance.getHotelInstance().getAllHotels();
            resault = objectMapper.writeValueAsString(hotels);
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
            Hotel hotel = Hotel.HotelBuilder.aHotel()
                    .withId(Integer.parseInt(map.get("idHotel").get(0)))
                    .withCity(map.get("city").get(0))
                    .withCountry(map.get("country").get(0))
                    .withName(map.get("name").get(0))
                    .withDescription(map.get("description").get(0))
                    .withWebsite(map.get("website").get(0))
                    .withStar(Integer.parseInt(map.get("star").get(0)))
                    .build();

            if (HotelInstance.getHotelInstance().updateHotelById(hotel)){
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
