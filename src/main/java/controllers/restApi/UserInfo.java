package controllers.restApi;

import org.apache.commons.io.IOUtils;
import storage.userInfo.UserInfoInstance;
import storage.userPass.UserPass;
import utils.Encode;
import utils.SplitQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/restApi/userInfo")
public class UserInfo extends HttpServlet {

    private static final String SUCCESSFULLY = "{\"successfully\":\"Registration completed successfully\"}";
    private static final String ARG_ERROR = "{\"error\":\"No arguments\"}";
    private static final String ADD_ERROR = "{\"error\":\"Unknown error, try again later\"}";
    private static final String USER_ERROR = "{\"error\":\"User not found\"}";
    private static final String MAIL_ERROR = "{\"error\":\"Mail already used\"}";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        super.doGet(req, resp);
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
                    .build();

            UserPass userPass = UserPass.UserPassBuilder.anUserPass()
                    .withPass(Encode.getSecurePassword(map.get("pass").get(0)))
                    .build();

            if (UserInfoInstance.getUserInfoInstance().addUserInfo(userInfo, userPass)){
                resp.getWriter().print(SUCCESSFULLY);
            }
            else {
                resp.setStatus(300);
                resp.getWriter().print(ADD_ERROR);
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

        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        super.doDelete(req, resp);
    }
}
