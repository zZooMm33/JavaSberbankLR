package storage.userInfo;

public class UserInfo {
    
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private String dateOfBirth;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Метод для создания билдера
     *
     * @return
     */
    public static UserInfo.Builder newBuilder() {
        return new UserInfo().new Builder();
    }

    public class Builder {
        public UserInfo.Builder setId(int id) {
            UserInfo.this.id = id;
            return this;
        }

        public UserInfo.Builder setFirstName(String firstName) {
            UserInfo.this.firstName = firstName;
            return this;
        }

        public UserInfo.Builder setLastName(String lastName) {
            UserInfo.this.lastName = lastName;
            return this;
        }

        public UserInfo.Builder setMail(String mail) {
            UserInfo.this.mail = mail;
            return this;
        }

        public UserInfo.Builder setDateOfBirth(String dateOfBirth) {
            UserInfo.this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserInfo.Builder setSex(String sex) {
            UserInfo.this.sex = sex;
            return this;
        }

        public UserInfo Build(){
            UserInfo userInfo = new UserInfo();

            userInfo.setId(UserInfo.this.id);
            userInfo.setFirstName(UserInfo.this.firstName);
            userInfo.setLastName(UserInfo.this.lastName);
            userInfo.setMail(UserInfo.this.mail);
            userInfo.setSex(UserInfo.this.sex);
            userInfo.setDateOfBirth(UserInfo.this.dateOfBirth);

            return userInfo;
        }
    }
}
