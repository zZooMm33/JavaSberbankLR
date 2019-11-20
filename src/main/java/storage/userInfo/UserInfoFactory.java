package storage.userInfo;

import storage.userInfo.DAO.UserInfoDAO;
import storage.userInfo.DAO.UserInfoHibernatePostgreSQL;
import storage.userInfo.DAO.UserInfoJDBCPostgreSQL;
import utils.PropReader;

/**
 * Фабрика для интерфейса UserInfoDAO
 */
public class UserInfoFactory {

    /**
     * Вернет интерфейсе для UserInfoDAO
     *
     * @return Вернет интерфейсе для HotelReviewDAO в зависимаости от настроек в config.properties
     */
    public UserInfoDAO factoryMethod() {
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("jdbcPostgreSQL")) return new UserInfoJDBCPostgreSQL();
        else if (storageType.equals("hibernatePostgreSQL")) return new UserInfoHibernatePostgreSQL();
        else return null;
    }
}
