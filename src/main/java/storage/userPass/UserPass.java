package storage.userPass;

public class UserPass {

    private int id;
    private int idUser;
    private String pass;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

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
