package storage;

public class ConnectionHibernate {

//    /**
//     * Синглтон для подключения к БД
//     */
//    static private SessionFactori connection = null;
//
//    /**
//     * Создает подключение к Бд
//     *
//     * @return Connection or null
//     */
//    public static Connection getConnection() {
//        try {
//            if (connection == null) {
//                String host = PropReader.getVal(PropReader.HOST),
//                        user = PropReader.getVal(PropReader.DATA_BASE_LOGIN),
//                        pass = PropReader.getVal(PropReader.DATA_BASE_PASS);
//
//
//                assert host != null;
//                connection = DriverManager.getConnection(host, user, pass);
//            }
//
//            return connection;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    /**
//     * Закрывает соединение с БД
//     */
//    public static void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            connection = null;
//        }
//    }
}
