package storage.userPass;

import storage.userPass.DAO.UserPassDAO;

/**
 * Синглтон для работы с UserPass
 */
public class UserPassInstance {
    /**
     * Синглтон UserPass
     */
    private static UserPassDAO userPassInstance = null;

    /**
     * Получение / создание UserPass
     *
     * @return UserPass
     */
    public static UserPassDAO getUserPassInstance() {
        if (userPassInstance == null) userPassInstance = new UserPassFactory().factoryMethod();
        return userPassInstance;
    }
}
