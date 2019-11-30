package storage.userInfo.DAO;

import storage.userInfo.UserInfo;
import storage.userPass.UserPass;
import storage.userToken.UserToken;

/**
 * Интерфейс сущности UserInfo
 */
public interface UserInfoDAO {

    /**
     * Добавить пользователя
     *
     * @param userInfo новый пользователь
     * @param userPass  пароль пользователя
     * @return удалось добавить или нет
     */
    public boolean addUserInfo(UserInfo userInfo, UserPass userPass, UserToken userToken);

    /**
     * Изменить пользователя
     *
     * @param userInfo новый пользователь
     * @return удалось добавить или нет
     */
    public boolean changeUserInfo(UserInfo userInfo);

    /**
     * Получить пользователя
     *
     * @param token token пользователя
     * @return пользователь
     */
    public UserInfo getUserInfoByToken(String token);


    /**
     * Получить пользователя
     *
     * @param mail mail пользователя
     * @return пользователь
     */
    public UserInfo getUserInfoByMail(String mail);
}
