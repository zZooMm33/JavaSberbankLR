package controllers.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import storage.hotel.Hotel;
import storage.userInfo.UserInfoInstance;
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

@WebServlet(urlPatterns = "/AdminPage")
public class AdminPage extends HttpServlet {

    /**
     * Переменная (для ftl) в которую будет записан список отелей
     */
    public static final String KEY_HOTEL_LIST = "hotels";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_ADMIN, webAddress, this);
        Set<Hotel> hotels = null;

        String token = Session.getFromSession(req, Session.KEY_TOKEN_STRING);

        try {
            if(!UserInfoInstance.getUserInfoInstance().getUserInfoByToken(token).isAdmin()) {
                resp.getWriter().println(FreeMarker.generateErrorPage("Error", webAddress, this));
                freeMarker.putString(FreeMarker.KEY_TOKEN, token);
                resp.getWriter().println(freeMarker);
                resp.setContentType("text/html");
                return;
            }

            String commJson= Request.sendGetRequest(webAddress+"/restApi/hotels");
            ObjectMapper mapper = new ObjectMapper();
            hotels = mapper.readValue(commJson, new TypeReference<Set<Hotel>>(){});
        }
        catch (Exception e){
            e.printStackTrace();
        }

        freeMarker.putList(KEY_HOTEL_LIST, hotels);
        freeMarker.putString(FreeMarker.KEY_TOKEN, token);
        resp.getWriter().println(freeMarker);
        resp.setContentType("text/html");
    }
}
