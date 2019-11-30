package controllers.restApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.IOUtils;
import storage.userInfo.UserInfoInstance;
import storage.userPass.UserPass;
import storage.userToken.UserToken;
import storage.userToken.UserTokenInstance;
import utils.Encode;
import utils.Session;
import utils.SplitQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(urlPatterns = "/restApi/userInfo")
public class UserInfo extends HttpServlet {

    private static final String SUCCESSFULLY = "{\"successfully\":\"Successfully\"}";
    private static final String ARG_ERROR = "{\"error\":\"No arguments\"}";
    private static final String UNKNOWN_ERROR = "{\"error\":\"Unknown error, try again later\"}";
    private static final String MAIL_ERROR = "{\"error\":\"Mail already used\"}";
    public static final String USER_NOT_FOUND = "{\"error\":\"User not found\"}";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);


        String token = req.getParameter("token");
        if (token != null){
            storage.userInfo.UserInfo userInfo = UserTokenInstance.getUserTokenInstance().getUserInfoByToken(token);
            resp.getWriter().print(objectMapper.writeValueAsString(userInfo));
        }
        else{
            resp.setStatus(300);
            resp.getWriter().print(USER_NOT_FOUND);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String body = IOUtils.toString(req.getReader());
        Map<String, List<String>> map = SplitQuery.split(body);

        try{
            storage.userInfo.UserInfo userInfo = storage.userInfo.UserInfo.UserInfoBuilder.anUserInfo()
                    .withMail(map.get("mail").get(0))
                    .withFirstName(map.get("first_name").get(0))
                    .withLastName(map.get("second_name").get(0))
                    .withSex(map.get("sex").get(0))
                    .withDateOfBirth(map.get("date").get(0))
                    .withAdmin(false)
                    .build();

            if (UserInfoInstance.getUserInfoInstance().getUserInfoByMail(userInfo.getMail()) != null){
                resp.setStatus(300);
                resp.getWriter().print(MAIL_ERROR);
                return;
            }

            UserPass userPass = UserPass.UserPassBuilder.anUserPass()
                    .withPass(Encode.getSecurePassword(map.get("pass").get(0)))
                    .build();

            storage.userToken.UserToken userToken = UserToken.UserTokenBuilder.anUserToken()
                    .withToken(UUID.randomUUID().toString())
                    .build();

            if (UserInfoInstance.getUserInfoInstance().addUserInfo(userInfo, userPass, userToken)){
                Session.addToSession(req, Session.KEY_TOKEN_STRING, userToken.getToken());
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
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String body = IOUtils.toString(req.getReader());
        Map<String, List<String>> map = SplitQuery.split(body);

        try{
            storage.userInfo.UserInfo userInfo = storage.userInfo.UserInfo.UserInfoBuilder.anUserInfo()
                    .withMail(map.get("mail").get(0))
                    .withFirstName(map.get("first_name").get(0))
                    .withLastName(map.get("second_name").get(0))
                    .withSex(map.get("sex").get(0))
                    .withDateOfBirth(map.get("date").get(0))
                    .build();

            // Находим нужного пользователя
            if (UserInfoInstance.getUserInfoInstance().getUserInfoByMail(userInfo.getMail()) != null){

                if (UserInfoInstance.getUserInfoInstance().changeUserInfo(userInfo)){
                    resp.getWriter().print(SUCCESSFULLY);
                }
                else {
                    resp.setStatus(300);
                    resp.getWriter().print(UNKNOWN_ERROR);
                }
            }
            else {
                resp.setStatus(300);
                resp.getWriter().print(USER_NOT_FOUND);
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
