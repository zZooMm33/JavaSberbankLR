package storage.userToken;

/**
 * Синглтон для работы с UserToken
 */
public class UserTokenInstance {
    /**
     * Синглтон UserToken
     */
    private static UserTokenDAO userTokenInstance = null;

    /**
     * Получение / создание UserToken
     *
     * @return UserToken
     */
    public static UserTokenDAO getUserTokenInstance() {
        if (userTokenInstance == null) userTokenInstance = new UserTokenFactory().factoryMethod();
        return userTokenInstance;
    }
}