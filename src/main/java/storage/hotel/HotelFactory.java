package storage.hotel;

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

        if (storageType.equals("databasePostgreSQL")) return new HotelDataBasePostgreSQL();
        else return null;
    }
}
