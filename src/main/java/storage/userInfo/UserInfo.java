package storage.userInfo;

import storage.hotelReview.HotelReview;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Сущность пользователя
 */
@Entity
@Table(name = "USER_INFO", schema = "public")
public class UserInfo {

    /**
     * id в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * Имя пользователя
     */
    @Column(name = "firstName", length = 60)
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "lastName", length = 60)
    private String lastName;

    /**
     * Почта пользователя
     */
    @Column(name = "mail", length = 100)
    private String mail;

    /**
     * Дата рождения
     */
    @Column(name = "dateOfBirth", length = 100)
    private String dateOfBirth;

    /**
     * Пол
     */
    @Column(name = "sex", length = 50)
    private String sex;

    /**
     * Администратор
     */
    @Column(name = "admin")
    private boolean admin;

    /**
     * Комментраии пользователя
     */
    @Transient
    private Set<HotelReview> hotelReview = new HashSet<HotelReview>();

    /**
     * Получить id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Сохранить id
     *
     * @param id новый id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получить имя
     *
     * @return Имя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Сохранить имя
     *
     * @param firstName новое имя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Получить фамилию
     *
     * @return фамилия
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Сохранить фамилию
     *
     * @param lastName новая фамилия
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Получить почту
     *
     * @return почта
     */
    public String getMail() {
        return mail;
    }

    /**
     * Сохранить почту
     *
     * @param mail новая почта
     */
    public void setMail(String mail) {
        this.mail = mail;
    }


    /**
     * Получить дату рождения
     *
     * @return дата рождения
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Сохранить дату рождения
     *
     * @param dateOfBirth дата рождения
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Получить пол
     * @return пол
     */
    public String getSex() {
        return sex;
    }

    /**
     * Сохранить пол
     * @param sex новый пол
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Является ли данный пользователь администратором
     * @return true/false
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Сделать пользователя администратором / убрать админку
     * @param admin true/false
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Получить комментарии данного пользователя
     * @return Комментарии
     */
    public Set<HotelReview> getHotelReview() {
        return hotelReview;
    }

    /**
     * Сохранить комментарии данного пользователя
     * @param hotelReview Комментарии
     */
    public void setHotelReview(Set<HotelReview> hotelReview) {
        this.hotelReview = hotelReview;
    }

    /**
     * Билдер
     */
    public static final class UserInfoBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private String mail;
        private String dateOfBirth;
        private String sex;
        private boolean admin;
        private Set<HotelReview> hotelReview = new HashSet<HotelReview>();

        private UserInfoBuilder() {
        }

        public static UserInfoBuilder anUserInfo() {
            return new UserInfoBuilder();
        }

        public UserInfoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public UserInfoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserInfoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserInfoBuilder withMail(String mail) {
            this.mail = mail;
            return this;
        }

        public UserInfoBuilder withDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserInfoBuilder withSex(String sex) {
            this.sex = sex;
            return this;
        }

        public UserInfoBuilder withAdmin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserInfoBuilder withHotelReview(Set<HotelReview> hotelReview) {
            this.hotelReview = hotelReview;
            return this;
        }

        public UserInfo build() {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(id);
            userInfo.setFirstName(firstName);
            userInfo.setLastName(lastName);
            userInfo.setMail(mail);
            userInfo.setDateOfBirth(dateOfBirth);
            userInfo.setSex(sex);
            userInfo.setAdmin(admin);
            userInfo.setHotelReview(hotelReview);
            return userInfo;
        }
    }
}
