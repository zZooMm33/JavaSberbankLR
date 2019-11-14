package storage.userPass;

public class UserPass {

    /**
     * id в таблице
     */
    private int id;
    /**
     * id пользователя
     */
    private int idUser;
    /**
     * Пароль пользователя
     */
    private String pass;

    /**
     * Получить id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Сохранит id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получить id пользователя
     * @return id пользователя
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Сохранит id польщователя
     * @param idUser id пользователя
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Получить пароль
     * @return пароль
     */
    public String getPass() {
        return pass;
    }

    /**
     * Сохранить пароль
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
        private int idUser;
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

        public UserPassBuilder withIdUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public UserPassBuilder withPass(String pass) {
            this.pass = pass;
            return this;
        }

        public UserPass build() {
            UserPass userPass = new UserPass();
            userPass.pass = this.pass;
            userPass.id = this.id;
            userPass.idUser = this.idUser;
            return userPass;
        }
    }
}
