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
     * Рейтинг (оценка)
     */
    private int rating;
    /**
     * Отзыв
     */
    private String description;

    /**
     * Метод для создания билдера
     *
     * @return
     */
    public static HotelReview.Builder newBuilder() {
        return new HotelReview().new Builder();
    }

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
     * Паттерн билдер
     */
    public class Builder {
        public HotelReview.Builder setId(int id) {
            HotelReview.this.id = id;
            return this;
        }

        public HotelReview.Builder setIdUser(int idUser) {
            HotelReview.this.idUser = idUser;
            return this;
        }

        public HotelReview.Builder setIdHotel(int idHotel) {
            HotelReview.this.idHotel = idHotel;
            return this;
        }

        public HotelReview.Builder setDateOfVisit(String dateOfVisit) {
            HotelReview.this.dateOfVisit = dateOfVisit;
            return this;
        }

        public HotelReview.Builder setRating(int rating) {
            HotelReview.this.rating = rating;
            return this;
        }

        public HotelReview.Builder setDescription(String description) {
            HotelReview.this.description = description;
            return this;
        }

        public HotelReview Build() {
            HotelReview hotelReview = new HotelReview();

            hotelReview.setId(HotelReview.this.id);
            hotelReview.setIdUser(HotelReview.this.idUser);
            hotelReview.setIdHotel(HotelReview.this.idHotel);
            hotelReview.setDateOfVisit(HotelReview.this.dateOfVisit);
            hotelReview.setRating(HotelReview.this.rating);
            hotelReview.setDescription(HotelReview.this.description);

            return hotelReview;
        }
    }
}
