package storage.hotelReview;

public class HotelReview {
    /**
     * id в таблице
     */
    private int id;
    /**
     * id пользователя
     */
    private int idUser;
    /**
     * id отеля
     */
    private int idHotel;
    /**
     * Дата посещения отеля
     */
    private String dateOfVisit;

    /**
     * Возраст пользователя на момент посещения отеля
     */
    private String userAgeOfVisit;
    /**
     * Рейтинг (оценка)
     */
    private int rating;
    /**
     * Отзыв
     */
    private String description;


    /**
     * Вернет id в таблице
     *
     * @return id в таблице
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
     * Вернет id пользоватля который оставил отзыв
     *
     * @return id пользователя
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Сохранит id пользователя
     *
     * @param idUser id пользователя
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Вернет id отеля о котором оставили отзыв
     *
     * @return id отеля
     */
    public int getIdHotel() {
        return idHotel;
    }

    /**
     * Сохранит id отеля о котором оставили отзыв
     *
     * @param idHotel id отеля
     */
    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    /**
     * Вернет дату посещения отеля
     *
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
     * @return Возраст пользователя
     */
    public String getUserAgeOfVisit() {
        return userAgeOfVisit;
    }

    /**
     * Сохранить возраст пользователя на момент посещения отела
     * @param userAgeOfVisit Возраст пользователя
     */
    public void setUserAgeOfVisit(String userAgeOfVisit) {
        this.userAgeOfVisit = userAgeOfVisit;
    }


    public static final class HotelReviewBuilder {
        private int id;
        private int idUser;
        private int idHotel;
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

        public HotelReviewBuilder withIdUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public HotelReviewBuilder withIdHotel(int idHotel) {
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
