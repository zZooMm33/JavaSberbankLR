package storage.userInfo;

import storage.userInfo.DAO.UserInfoDAO;

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
     *
     * @return UserInfo
     */
    public static UserInfoDAO getUserInfoInstance() {
        if (userInfoInstance == null) userInfoInstance = new UserInfoFactory().factoryMethod();
        return userInfoInstance;
    }
}
