package storage.userInfo.DAO;

import storage.userInfo.UserInfo;
import storage.userPass.UserPass;

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
    public boolean addUserInfo(UserInfo userInfo, UserPass userPass);

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
     * @param id id пользователя
     * @return пользователь
     */
    public UserInfo getUserInfoById(int id);


    /**
     * Получить пользователя
     *
     * @param mail mail пользователя
     * @return пользователь
     */
    public UserInfo getUserInfoByMail(String mail);
}
