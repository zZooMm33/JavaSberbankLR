package storage.userPass;

import storage.userPass.DAO.UserPassDAO;
import storage.userPass.DAO.UserPassHibernatePostgreSQL;
import storage.userPass.DAO.UserPassJDBCPostgreSQL;
import utils.PropReader;

/**
 * Фабрика для интерфейса UserPassDAO
 */
public class UserPassFactory {
    /**
     * Вернет интерфейсе для UserPassDAO
     *
     * @return Вернет интерфейсе для UserPassDAO в зависимаости от настроек в config.properties
     */
    public UserPassDAO factoryMethod() {
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("jdbcPostgreSQL")) return new UserPassJDBCPostgreSQL();
        else if (storageType.equals("hibernatePostgreSQL")) return new UserPassHibernatePostgreSQL();
        else return null;
    }
}
