package controllers.restApi;

import org.apache.commons.io.IOUtils;
import utils.PropReader;
import utils.SplitQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/restApi/config")
public class Config extends HttpServlet {
    private static final String SUCCESSFULLY = "{\"successfully\":\"Successfully\"}";
    private static final String ARG_ERROR = "{\"error\":\"No arguments\"}";
    private static final String UNKNOWN_ERROR = "{\"error\":\"Unknown error, try again later\"}";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String body = IOUtils.toString(req.getReader());
        Map<String, List<String>> map = SplitQuery.split(body);

        try{
            String maintenance = map.get("maintenance").get(0);
            if (PropReader.setVal(PropReader.MAINTENANCE, maintenance)){
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
        super.doDelete(req, resp);
    }
}
