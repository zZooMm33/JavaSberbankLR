package storage.hotelReview;

import storage.hotel.HotelDAO;
import storage.hotel.HotelDataBasePostgreSQL;
import utils.PropReader;

public class HotelReviewFactory {
    /**
     * Вернет интерфейсе для HotelReviewDAO
     *
     * @return Вернет интерфейсе для HotelReviewDAO в зависимаости от настроек в config.properties
     */
    public HotelReviewDAO factoryMethod(){
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("databasePostgreSQL")) return new HotelReviewDataBasePostgreSQL();
        else return null;
    }
}
