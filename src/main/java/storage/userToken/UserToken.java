package storage.userToken;

public class UserToken {

    /**
     * id в таблице
     */
    private int id;
    /**
     * id пользователя
     */
    private int idUser;
    /**
     * token пользователя
     */
    private String token;

    /**
     * Получить id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Сохранит id
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получить id пользователя
     *
     * @return id пользователя
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Сохранит id польщователя
     *
     * @param idUser id пользователя
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Получить token
     *
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * Сохранить token
     *
     * @param token новый token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Билдер
     */
    public static final class UserTokenBuilder {
        private int id;
        private int idUser;
        private String token;

        private UserTokenBuilder() {
        }

        public static UserTokenBuilder anUserToken() {
            return new UserTokenBuilder();
        }

        public UserTokenBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public UserTokenBuilder withIdUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public UserTokenBuilder withToken(String token) {
            this.token = token;
            return this;
        }

        public UserToken build() {
            UserToken userToken = new UserToken();
            userToken.token = this.token;
            userToken.id = this.id;
            userToken.idUser = this.idUser;
            return userToken;
        }
    }
}
