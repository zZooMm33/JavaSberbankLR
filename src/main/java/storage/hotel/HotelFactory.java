package storage.hotel;

import storage.hotel.DAO.HotelDAO;
import storage.hotel.DAO.HotelHibernatePostgreSQL;
import storage.hotel.DAO.HotelJDBCPostgreSQL;
import utils.PropReader;

/**
 * Фабрика для интерфейса HotelDAO
 */
public class HotelFactory {

    /**
     * Вернет интерфейсе для HotelDAO
     *
     * @return Вернет интерфейсе для HotelDAO в зависимаости от настроек в config.properties
     */
    public HotelDAO factoryMethod() {
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("jdbcPostgreSQL")) return new HotelJDBCPostgreSQL();
        else if (storageType.equals("hibernatePostgreSQL")) return new HotelHibernatePostgreSQL();
        else return null;
    }
}
