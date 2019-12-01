package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Используется для считывания строк из config.properties
 */
public class PropReader {

    /**
     * Конфиг файл
     */
    private static final String PROP_FILE_NAME = "config.properties";

    /**
     * Поле host в config
     */
    public static final String HOST = "host";

    /**
     * Поле dbLogin в config
     */
    public static final String DATA_BASE_LOGIN = "dbLogin";

    /**
     * Поле dbPass в config
     */
    public static final String DATA_BASE_PASS = "dbPass";

    /**
     * Поле storageType в config
     */
    public static final String STORAGE_TYPE = "storageType";

    /**
     * Поле maintenance в config
     */
    public static final String MAINTENANCE = "maintenance";

    /**
     * Вернет строку по ключу из config.properties
     *
     * @param key Ключ в config.properties
     * @return Вернет значение по ключу
     */
    public static String getVal(String key) {

        Properties prop = new Properties();

        InputStream inputStream = PropReader.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);

        if (inputStream != null) {
            try {
                prop.load(inputStream);
                return prop.getProperty(key);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return null;
    }

    /**
     * Сохранить настройки в config.properties
     * @param key ключ
     * @param value новое значение
     * @return удалось сохранить или нет
     */
    public static boolean setVal(String key, String value){

        try {
            FileOutputStream out = new FileOutputStream("src/main/resources/"+PROP_FILE_NAME);
            Properties props = new Properties();
            props.setProperty(key, value);
            props.store(out, null);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
