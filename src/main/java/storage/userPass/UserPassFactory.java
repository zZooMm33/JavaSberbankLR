package storage.userPass;

import utils.PropReader;

/**
 * Фабрика для интерфейса UserPassDAO
 */
public class UserPassFactory {
    /**
     * Вернет интерфейсе для UserPassDAO
     * @return Вернет интерфейсе для UserPassDAO в зависимаости от настроек в config.properties
     */
    public UserPassDAO factoryMethod(){
        String storageType = PropReader.getVal("storageType");

        if (storageType.equals("databasePostgreSQL")) return new UserPassDataBasePostgreSQL();
        else return null;
    }
}
