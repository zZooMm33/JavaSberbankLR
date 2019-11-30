package utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Класс для работы с FreeMarker api
 */
public class FreeMarker {

    private Configuration cfgFreeMarker = null;
    private Template temp = null;
    private Writer outFreeMarker = null;

    private Map<String, Object> freeMarkerMap = null;

    /**
     * Страницы сайта (для пользователей)
     */
    public static final String FILE_INDEX = "index.ftl";
    public static final String FILE_HOTEL_CARD = "hotelCard.ftl";
    public static final String FILE_PROFILE = "userProfile.ftl";
    public static final String FILE_REG = "registration.ftl";
    public static final String FILE_LOGIN = "login.ftl";

    /**
     * Страницы сайта для администратора
     */
    public static final String FILE_ADMIN = "admin.ftl";

    /**
     * Страницы с ошибками
     */
    public static final String FILE_ERROR = "error.ftl";


    /**
     * Переменные
     */
    public static final String KEY_WEB_ADDRESS = "webAddress";
    public static final String KEY_ERROR = "errorText";
    public static final String KEY_TOKEN = "token";

    /**
     * Конструктор
     *
     * @param templateName Имя шаблона
     * @param webAddress   Текущий веб-адрес
     * @param servletClass Класс для поиска шаблонов в ресурсах
     */
    public FreeMarker(String templateName, String webAddress, Object servletClass) {
        try {
            this.cfgFreeMarker = new Configuration(Configuration.VERSION_2_3_28);
            cfgFreeMarker.setClassForTemplateLoading(servletClass.getClass(), "/frontEnd/");
            this.temp = cfgFreeMarker.getTemplate(templateName);
            this.outFreeMarker = new StringWriter();
            this.freeMarkerMap = new HashMap<>();
            this.putString(KEY_WEB_ADDRESS, webAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавить строковое значение по ключу в шаблон hashmap
     *
     * @param key Ключ
     * @param val Значение
     */
    public void putString(String key, String val) {
        freeMarkerMap.put(key, val);
    }

    /**
     * Добавить значение по ключу к шаблону hashmap
     *
     * @param key Ключ
     * @param val Значение
     */
    public void putVal(String key, Object val) {
        freeMarkerMap.put(key, val);
    }

    /**
     * Добавить значения списка в шаблон hashmap
     *
     * @param key  Ключ
     * @param list Список объектов
     */
    public void putList(String key, Set<?> list) {
        freeMarkerMap.put(key, list);
    }

    /**
     * Вернет страницу с ошибкой
     *
     * @param errorText    Текст ошибки
     * @param webAdress    Текущий веб-адрес
     * @param servletClass Класс сервлета
     * @return Текст страницы
     */
    public static String generateErrorPage(String errorText, String webAdress, Object servletClass) {
        FreeMarker fMarker = new FreeMarker(FreeMarker.FILE_ERROR, webAdress, servletClass);
        fMarker.putString(FreeMarker.KEY_ERROR, errorText);
        return fMarker.toString();
    }


    /**
     * Преобразовать шаблон в страку
     *
     * @return Строка с созданным шаблоном или пустая строка
     */
    @Override
    public String toString() {
        try {
            temp.process(freeMarkerMap, outFreeMarker);
            return outFreeMarker.toString();
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
