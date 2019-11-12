package storage.userToken;

public class UserToken {
    private int id;
    private int idUser;
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

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
