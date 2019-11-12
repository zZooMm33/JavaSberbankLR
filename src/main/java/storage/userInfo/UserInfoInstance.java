package storage.userInfo;
/**
 * Синглтон для работы с UserInfo
 */
public class UserInfoInstance {

    /**
     * Синглтон UserInfo
     */
    private static UserInfoDAO userInfoInstance = null;

    /**
     * Получение / создание UserInfo
     * @return отель
     */
    public static UserInfoDAO getUserInfoInstance(){
        if (userInfoInstance == null) userInfoInstance = new UserInfoFactory().factoryMethod();
        return userInfoInstance;
    }
}
