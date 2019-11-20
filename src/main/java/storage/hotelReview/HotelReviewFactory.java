package storage.hotelReview;

import storage.hotelReview.DAO.HotelReviewDAO;
import storage.hotelReview.DAO.HotelReviewHibernatePostgreSQL;
import storage.hotelReview.DAO.HotelReviewJDBCPostgreSQL;
import utils.PropReader;

/**
 * Фабрика для интерфейса HotelReviewDAO
 */
public class HotelReviewFactory {
    /**
     * Вернет интерфейсе для HotelReviewDAO
     *
     * @return Вернет интерфейсе для HotelReviewDAO в зависимаости от настроек в config.properties
     */
    public HotelReviewDAO factoryMethod() {
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("jdbcPostgreSQL")) return new HotelReviewJDBCPostgreSQL();
        else if (storageType.equals("hibernatePostgreSQL")) return new HotelReviewHibernatePostgreSQL();
        else return null;
    }
}
