package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {
    /**
     * Поле для создания токина
     */
    public static final String KEY_TOKEN_STRING = "token";

    public static void addToSession(HttpServletRequest req, String key, String value)
    {
        HttpSession session = req.getSession();
        if (session != null)
            session.setAttribute(key, value);
        else System.out.println("session == null\n");
    }

    public static String getFromSession(HttpServletRequest req, String key)
    {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute(key)!=null) {
            return session.getAttribute(key).toString();
        }
        else return null;
    }

    public static void clearSession(HttpServletRequest req)
    {
        removeAttrFromSession(req, KEY_TOKEN_STRING);
    }

    public static void removeAttrFromSession(HttpServletRequest req, String key)
    {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute(key)!=null)
            session.removeAttribute(key);
    }
}
