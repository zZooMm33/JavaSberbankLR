package storage.userPass.DAO;

import storage.userPass.UserPass;

/**
 * Интерфейс сущности UserPass
 */
public interface UserPassDAO {

    /**
     * Добавить пароль
     *
     * @param userPass новый UserPass
     * @return удалось или не удалось добавить
     */
    public boolean addUserPass(UserPass userPass);

    /**
     * Изменить пароль
     *
     * @param userPass новый UserPass
     * @return удалось или не удалось добавить
     */
    public boolean changeUserPass(UserPass userPass);

    /**
     * Получить пароль
     *
     * @param userId id пользователя
     * @return UserPass
     */
    public UserPass getUserPassByUserId(int userId);
}
