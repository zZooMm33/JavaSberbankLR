package storage.userPass;

/**
 * Синглтон для работы с UserPass
 */
public class UserPassInstance {
    /**
     * Синглтон UserPass
     */
    private static UserPassDAO userPassInstance = null;

    /**
     * Получение / создание UserInfo
     * @return отель
     */
    public static UserPassDAO getUserPassInstance(){
        if (userPassInstance == null) userPassInstance = new UserPassFactory().factoryMethod();
        return userPassInstance;
    }
}
