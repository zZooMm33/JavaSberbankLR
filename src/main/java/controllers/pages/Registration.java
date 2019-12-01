package controllers.pages;

import utils.FreeMarker;
import utils.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для регистрации пользователя
 */
@WebServlet(urlPatterns = "/Registration")
public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String webAddress = "" + req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        FreeMarker freeMarker = new FreeMarker(FreeMarker.FILE_REG, webAddress, this);

        String token = Session.getFromSession(req, Session.KEY_TOKEN_STRING);
        freeMarker.putString(FreeMarker.KEY_TOKEN, token);

        resp.getWriter().println(freeMarker);
        resp.setContentType("text/html");
    }
}
