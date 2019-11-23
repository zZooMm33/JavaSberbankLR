package storage.userToken;

import storage.userInfo.UserInfo;

import javax.persistence.*;

/**
 * Сущность для авторизации
 */
@Entity
@Table(name = "USER_TOKEN", schema = "public")
public class UserToken {

    /**
     * id в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    /**
     * Пользователь
     */
    @OneToOne(cascade=CascadeType.ALL)
    private UserInfo user;
    /**
     * token пользователя
     */
    @Column(name = "token", length = 256)
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
     * Получить пользователя
     *
     * @return пользователь
     */
    public UserInfo getUser() {
        return user;
    }

    /**
     * Сохранит польщователя
     *
     * @param user пользователь
     */
    public void setUser(UserInfo user) {
        this.user = user;
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
        private UserInfo user;
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

        public UserTokenBuilder withUser(UserInfo user) {
            this.user = user;
            return this;
        }

        public UserTokenBuilder withToken(String token) {
            this.token = token;
            return this;
        }

        public UserToken build() {
            UserToken userToken = new UserToken();
            userToken.setId(id);
            userToken.setUser(user);
            userToken.setToken(token);
            return userToken;
        }
    }
}
