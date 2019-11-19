package storage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate
 */
public class ConnectionHibernate {

    /**
     * Синглтон для подключения к Hibernate
     */
    static private SessionFactory connection = null;

    /**
     * Создает подключение к Hibernate
     *
     * @return Connection or null
     */
    public static SessionFactory getConnection() {
        if (connection == null || connection.isClosed()) {
            connection = new Configuration().configure().buildSessionFactory();
        }
        return connection;
    }

    /**
     * Закрывает соединение с Hibernate
     */
    public static void closeConnection() {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}
