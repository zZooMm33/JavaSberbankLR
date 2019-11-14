package storage.userInfo;

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

        if (storageType.equals("databasePostgreSQL")) return new UserInfoDataBasePostgreSQL();
        else return null;
    }
}
