package storage.userPass;

import storage.userInfo.UserInfo;

import javax.persistence.*;

/**
 * Сущность хранящая пароль пользователя
 */
@Entity
@Table(name = "USER_PASS", schema = "public")
public class UserPass {

    /**
     * id в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    /**
     * Пользователь пользователя
     */
    @OneToOne(cascade=CascadeType.ALL)
    private UserInfo user;
    /**
     * Пароль пользователя
     */
    @Column(name = "pass", length = 256)
    private String pass;

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
     * Сохранить пользователя
     *
     * @param user пользователь
     */
    public void setUser(UserInfo user) {
        this.user = user;
    }

    /**
     * Получить пароль
     *
     * @return пароль
     */
    public String getPass() {
        return pass;
    }

    /**
     * Сохранить пароль
     *
     * @param pass пароль
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Билдер
     */
    public static final class UserPassBuilder {
        private int id;
        private UserInfo user;
        private String pass;

        private UserPassBuilder() {
        }

        public static UserPassBuilder anUserPass() {
            return new UserPassBuilder();
        }

        public UserPassBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public UserPassBuilder withUser(UserInfo user) {
            this.user = user;
            return this;
        }

        public UserPassBuilder withPass(String pass) {
            this.pass = pass;
            return this;
        }

        public UserPass build() {
            UserPass userPass = new UserPass();
            userPass.setId(id);
            userPass.setPass(pass);
            userPass.user = this.user;
            return userPass;
        }
    }
}
