package storage.userToken.DAO;

import storage.userInfo.UserInfo;
import storage.userToken.UserToken;

/**
 * Интерфейс сущности UserToken
 */
public interface UserTokenDAO {
    /**
     * Добавить UserToken
     *
     * @param userToken новый UserToken
     * @return удалось или не удалось
     */
    public boolean addUserToken(UserToken userToken);

    /**
     * Удалить UserToken
     *
     * @param token token по которому удалить
     * @return удалось или не удалось
     */
    public boolean deleteUserTokenByToken(String token);

    /**
     * Изменить UserToken
     *
     * @param userToken новый UserToken
     * @return удалось или не удалось
     */
    public boolean changeUserToken(UserToken userToken);

    /**
     * Получить токен по id
     * @param idUser id пользователя
     * @return UserToken
     */
    public boolean deleteUserTokenByUserId(int idUser);

    /**
     * Получить пользователя по токену
     * @param token token
     * @return UserInfo
     */
    public UserInfo getUserInfoByToken(String token);
}
