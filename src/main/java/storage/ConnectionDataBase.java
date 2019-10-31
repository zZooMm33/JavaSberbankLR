package storage;

import utils.PropReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для подключения к БД
 */
public class ConnectionDataBase {
    /**
     * Синглтон для подключения к БД
     */
    static private Connection connection = null;

    /**
     * Создает подключение к Бд
     *
     * @return Connection or null
     */
    public static Connection getConnection() {
        try {
            if (connection == null) {
                String host = PropReader.getVal("host"),
                        pass = PropReader.getVal("dbPass"),
                        user = PropReader.getVal("dbName");

                //Class.forName("org.h2.Driver");

                if (pass.equals("null")) {
                    pass = null;
                }

                connection = DriverManager.getConnection(host, user, pass);
            }

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Закрывает соединение с БД
     */
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {

        }

    }
}
