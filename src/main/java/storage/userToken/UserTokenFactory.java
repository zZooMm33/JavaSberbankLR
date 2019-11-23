package storage.userToken;

import storage.userToken.DAO.UserTokenDAO;
import storage.userToken.DAO.UserTokenHibernatePostgreSQL;
import storage.userToken.DAO.UserTokenJDBCPostgreSQL;
import utils.PropReader;

/**
 * Фабрика для интерфейса UserTokenDAO
 */
public class UserTokenFactory {
    /**
     * Вернет интерфейсе для UserTokenDAO
     *
     * @return Вернет интерфейсе для UserTokenDAO в зависимаости от настроек в config.properties
     */
    public UserTokenDAO factoryMethod() {
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("jdbcPostgreSQL")) return new UserTokenJDBCPostgreSQL();
        else if (storageType.equals("hibernatePostgreSQL")) return new UserTokenHibernatePostgreSQL();
        else return null;
    }
}
