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
                String host = PropReader.getVal(PropReader.HOST),
                        user = PropReader.getVal(PropReader.DATA_BASE_LOGIN),
                        pass = PropReader.getVal(PropReader.DATA_BASE_PASS);


                assert host != null;
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
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
