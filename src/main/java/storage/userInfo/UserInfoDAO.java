package storage.userInfo;

/**
 * Интерфейс сущности UserInfo
 */
public interface UserInfoDAO {

    /**
     * Добавить пользователя
     *
     * @param userInfo новый пользователь
     * @return удалось добавить или нет
     */
    public boolean addUserInfo(UserInfo userInfo);

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
