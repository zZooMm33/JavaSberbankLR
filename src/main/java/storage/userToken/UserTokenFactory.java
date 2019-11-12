package storage.userToken;

import utils.PropReader;
/**
 * Фабрика для интерфейса UserTokenDAO
 */
public class UserTokenFactory {
    /**
     * Вернет интерфейсе для UserTokenDAO
     * @return Вернет интерфейсе для UserTokenDAO в зависимаости от настроек в config.properties
     */
    public UserTokenDAO factoryMethod(){
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("databasePostgreSQL")) return new UserTokenDataBasePostgreSQL();
        else return null;
    }
}
