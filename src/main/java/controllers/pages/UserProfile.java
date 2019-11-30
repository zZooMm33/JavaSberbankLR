package controllers.pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import storage.userInfo.UserInfo;
import utils.FreeMarker;
import utils.Request;
import utils.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Profile")
public class UserProfile extends HttpServlet {

    /**
     * Переменная (для ftl) в которую будут записаны данные пользователя
     */
    public static final String KEY_USER_INFO = "userInfo";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_PROFILE, webAddress, this);
        String token = Session.getFromSession(req, Session.KEY_TOKEN_STRING);
        UserInfo userInfo = null;

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

        freeMarker.putString(FreeMarker.KEY_TOKEN, token);
        freeMarker.putVal(KEY_USER_INFO, userInfo);
        resp.getWriter().println(freeMarker);
        resp.setContentType("text/html");
    }
}
