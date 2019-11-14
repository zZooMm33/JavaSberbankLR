package storage.userToken;

/**
 * Интерфейс сущности UserToken
 */
public interface UserTokenDAO {
    /**
     * Добавить UserToken
     * @param userToken новый UserToken
     * @return удалось или не удалось
     */
    public boolean addUserToken(UserToken userToken);

    /**
     * Удалить UserToken
     * @param token token по которому удалить
     * @return удалось или не удалось
     */
    public boolean deleteUserTokenByToken(String token);

    /**
     * Изменить UserToken
     * @param userToken новый UserToken
     * @return удалось или не удалось
     */
    public boolean changeUserToken(UserToken userToken);
}
