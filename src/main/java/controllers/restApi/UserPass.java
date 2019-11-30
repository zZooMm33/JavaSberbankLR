package controllers.restApi;

import org.apache.commons.io.IOUtils;
import storage.userInfo.UserInfo;
import storage.userInfo.UserInfoInstance;
import storage.userPass.UserPassInstance;
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

@WebServlet(urlPatterns = "/restApi/userPass")
public class UserPass extends HttpServlet {

    private static final String SUCCESSFULLY = "{\"successfully\":\"\"}";
    private static final String ARG_ERROR = "{\"error\":\"No arguments\"}";
    private static final String MAIL_ERROR = "{\"error\":\"User not found\"}";
    private static final String PASS_ERROR = "{\"error\":\"Error in password\"}";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * Проверка пароля для входа и авторизация
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String body = IOUtils.toString(req.getReader());
        Map<String, List<String>> map = SplitQuery.split(body);

        try {
            String mail =map.get("mail").get(0),
                    pass = map.get("pass").get(0);

            UserInfo userInfo = UserInfoInstance.getUserInfoInstance().getUserInfoByMail(mail);

            if (userInfo != null){
                storage.userPass.UserPass userPass = UserPassInstance.getUserPassInstance().getUserPassByUserId(userInfo.getId());

                if (userPass != null){
                    if (userPass.getPass().equals(Encode.getSecurePassword(pass))){
                        // удаляем токен
                        UserTokenInstance.getUserTokenInstance().deleteUserTokenByUserId(userInfo.getId());
                        UserToken userToken = UserToken.UserTokenBuilder.anUserToken()
                                .withUser(userInfo)
                                .withToken(UUID.randomUUID().toString())
                                .build();
                        // добавляем токен
                        UserTokenInstance.getUserTokenInstance().addUserToken(userToken);
                        // добавляем токен в сессию
                        Session.addToSession(req, Session.KEY_TOKEN_STRING, userToken.getToken());
                        resp.getWriter().print(SUCCESSFULLY);
                    }
                    else {
                        resp.setStatus(300);
                        resp.getWriter().print(PASS_ERROR);
                    }
                }
                else{
                    resp.setStatus(300);
                    resp.getWriter().print(PASS_ERROR);
                }
            }
            else{
                resp.setStatus(300);
                resp.getWriter().print(MAIL_ERROR);
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
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
