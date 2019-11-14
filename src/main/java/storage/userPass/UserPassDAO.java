package storage.userPass;

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
     * @param id id пользователя
     * @return пароль
     */
    public String getPassByUserId(int id);
}
