package storage.hotelReview;

import storage.hotel.Hotel;
import storage.userInfo.UserInfo;

import javax.persistence.*;

/**
 * Сущность комментариев отеля
 */
@Entity
@Table(name = "HotelReview", schema = "public")
public class HotelReview {
    /**
     * id в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    /**
     * id пользователя (сущность)
     */
    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserInfo idUser;

    /**
     * id отеля (сущность)
     */
    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel idHotel;

    /**
     * Дата посещения отеля
     */
    @Column(name = "dateOfVisit", length = 100)
    private String dateOfVisit;


    /**
     * Возраст пользователя на момент посещения отеля
     */
    @Column(name = "userAgeOfVisit", length = 100)
    private String userAgeOfVisit;

    /**
     * Рейтинг (оценка)
     */
    @Column(name = "rating")
    private int rating;

    /**
     * Отзыв
     */
    @Column(name = "description")
    private String description;


    /**
     * Вернет id в таблице
     * @return id в таблице
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
     * Пользователь который оставил комментарий
     * @return пользователь
     */
    public UserInfo getIdUser() {
        return idUser;
    }

    /**
     * Сохранит нового пользователя
     * @param idUser пользователь
     */
    public void setIdUser(UserInfo idUser) {
        this.idUser = idUser;
    }

    /**
     * Вернет отель для которого был добавлен комментарий
     * @return комментарий
     */
    public Hotel getIdHotel() {
        return idHotel;
    }

    /**
     * Сохранит отель для которого был добавлен комментарий
     * @param idHotel отель
     */
    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }

    /**
     * Вернет дату посещения отеля
     * @return дата посещения отеля
     */
    public String getDateOfVisit() {
        return dateOfVisit;
    }

    /**
     * Сохранит дату посещения отеля
     *
     * @param dateOfVisit дата посещения отеля
     */
    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    /**
     * Вернет оценку которую оставил пользователь об данном отеле
     *
     * @return оценка
     */
    public int getRating() {
        return rating;
    }

    /**
     * Сохранит оценку об отеле
     *
     * @param rating оценка
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Вернет текст отзыва
     *
     * @return отзыв
     */
    public String getDescription() {
        return description;
    }

    /**
     * Сохранит текст отзыва
     *
     * @param description отзыв
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получить возраст пользователя на момент посещения отела
     *
     * @return Возраст пользователя
     */
    public String getUserAgeOfVisit() {
        return userAgeOfVisit;
    }

    /**
     * Сохранить возраст пользователя на момент посещения отела
     *
     * @param userAgeOfVisit Возраст пользователя
     */
    public void setUserAgeOfVisit(String userAgeOfVisit) {
        this.userAgeOfVisit = userAgeOfVisit;
    }

    /**
     * Билдер
     */
    public static final class HotelReviewBuilder {
        private int id;
        private UserInfo idUser;
        private Hotel idHotel;
        private String dateOfVisit;
        private String userAgeOfVisit;
        private int rating;
        private String description;

        private HotelReviewBuilder() {
        }

        public static HotelReviewBuilder aHotelReview() {
            return new HotelReviewBuilder();
        }

        public HotelReviewBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public HotelReviewBuilder withIdUser(UserInfo idUser) {
            this.idUser = idUser;
            return this;
        }

        public HotelReviewBuilder withIdHotel(Hotel idHotel) {
            this.idHotel = idHotel;
            return this;
        }

        public HotelReviewBuilder withDateOfVisit(String dateOfVisit) {
            this.dateOfVisit = dateOfVisit;
            return this;
        }

        public HotelReviewBuilder withUserAgeOfVisit(String userAgeOfVisit) {
            this.userAgeOfVisit = userAgeOfVisit;
            return this;
        }

        public HotelReviewBuilder withRating(int rating) {
            this.rating = rating;
            return this;
        }

        public HotelReviewBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public HotelReview build() {
            HotelReview hotelReview = new HotelReview();
            hotelReview.setId(id);
            hotelReview.setIdUser(idUser);
            hotelReview.setIdHotel(idHotel);
            hotelReview.setDateOfVisit(dateOfVisit);
            hotelReview.setUserAgeOfVisit(userAgeOfVisit);
            hotelReview.setRating(rating);
            hotelReview.setDescription(description);
            return hotelReview;
        }
    }
}
