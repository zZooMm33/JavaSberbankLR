package controllers.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import storage.hotel.Hotel;
import storage.hotelReview.HotelReview;
import storage.userInfo.UserInfo;
import storage.userToken.UserTokenInstance;
import utils.FreeMarker;
import utils.Request;
import utils.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = "/Profile")
public class UserProfile extends HttpServlet {

    /**
     * Переменная (для ftl) в которую будут записаны данные пользователя
     */
    public static final String KEY_USER_INFO = "userInfo";

    /**
     * Переменная (для ftl) в которую будет записан список отелей
     */
    public static final String KEY_HOTEL_LIST = "hotels";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_PROFILE, webAddress, this);
        String token = Session.getFromSession(req, Session.KEY_TOKEN_STRING);
        UserInfo userInfo = null;
        Set<Hotel> hotels = null;

        userInfo = UserTokenInstance.getUserTokenInstance().getUserInfoByToken(token);

        if(userInfo == null) {
            resp.getWriter().println(FreeMarker.generateErrorPage("Error", webAddress, this));
            resp.setContentType("text/html");
            return;
        }

        userInfo = null;

        try {
            String commJson= Request.sendGetRequest(webAddress+"/restApi/hotels");
            ObjectMapper mapper = new ObjectMapper();
            hotels = mapper.readValue(commJson, new TypeReference<Set<Hotel>>(){});
        }
        catch (Exception e){
            e.printStackTrace();
        }

        freeMarker.putList(KEY_HOTEL_LIST, hotels);

        try {
            String commJson= Request.sendGetRequest(webAddress+"/restApi/userInfo?token=" + token);

            if (!commJson.equals(controllers.restApi.UserInfo.USER_NOT_FOUND)){
                ObjectMapper mapper = new ObjectMapper();
                userInfo = mapper.readValue(commJson, UserInfo.class);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (userInfo != null){
            try {
                String commJson= Request.sendGetRequest(webAddress+"/restApi/hotelReviews?idUser=" + userInfo.getId());
                ObjectMapper mapper = new ObjectMapper();
                userInfo.setHotelReview(mapper.readValue(commJson, new TypeReference<Set<HotelReview>>(){}));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        freeMarker.putVal(KEY_USER_INFO, userInfo);

        freeMarker.putString(FreeMarker.KEY_TOKEN, token);

        resp.getWriter().println(freeMarker);
        resp.setContentType("text/html");
    }
}
