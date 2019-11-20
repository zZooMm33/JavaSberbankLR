package storage.hotel;

import storage.hotelReview.HotelReview;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Сущность отеля
 */
@Entity
@Table(name = "Hotel", schema = "public")
public class Hotel {

    /**
     * id отеля
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    /**
     * Название
     */
    @Column(name = "name", length = 60)
    private String name;

    /**
     * Описание
     */
    @Column(name = "description")
    private String description;

    /**
     * Страна расположения
     */
    @Column(name = "country", length = 60)
    private String country;

    /**
     * Город расположения
     */
    @Column(name = "city", length = 60)
    private String city;

    /**
     * Количество звезд
     */
    @Column(name = "star")
    private int star;

    /**
     * Веб сайт отеля
     */
    @Column(name = "website", length = 60)
    private String website;


    /**
     * Средняя оценка
     */
    @Column(name = "averageRating")
    private int averageRating;

    /**
     * Комментарии отеля
     */
    @OneToMany
    @OrderBy("idHotel")
    private ArrayList<HotelReview> hotelReview = new ArrayList<HotelReview>();

    /**
     * Вернет id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Сохранит id
     *
     * @param id id отеля
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Вернет название отеля
     *
     * @return название отеля
     */
    public String getName() {
        return name;
    }

    /**
     * Сохранит название отеля
     *
     * @param name название отеля
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Вернет описание отеля
     *
     * @return описание отеля
     */
    public String getDescription() {
        return description;
    }

    /**
     * Сохранит описание отеля
     *
     * @param description описание отеля
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Вернет страну расположения отеля
     *
     * @return название страны
     */
    public String getCountry() {
        return country;
    }

    /**
     * Сохранит страну расположения отеля
     *
     * @param country название страны
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Вернет город расположения отеля
     *
     * @return название города
     */
    public String getCity() {
        return city;
    }

    /**
     * Сохранит город расположения отеля
     *
     * @param city город
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Вернет кол-во звезд отеля
     *
     * @return кол-во звезд
     */
    public int getStar() {
        return star;
    }

    /**
     * Сохранит кол-во звезд отеля
     *
     * @param star кол-во звезд
     */
    public void setStar(int star) {
        this.star = star;
    }

    /**
     * Вернет сайт отеля
     *
     * @return сайт отеля
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Сохранит сайт отеля
     *
     * @param website сайт отеля
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Получить среднюю оценку
     *
     * @return Средняя оценка
     */
    public int getAverageRating() {
        return averageRating;
    }

    /**
     * Сохранить среднюю оценку
     *
     * @param averageRating Средняя оценка
     */
    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    /**
     * Получить комментарии данного отеля
     * @return Комментарии
     */
    public ArrayList<HotelReview> getHotelReview() {
        return hotelReview;
    }

    /**
     * Сохранить комментарии данного отеля
     * @param hotelReview Комментарии
     */
    public void setHotelReview(ArrayList<HotelReview> hotelReview) {
        this.hotelReview = hotelReview;
    }

    /**
     * Билдер
     */
    public static final class HotelBuilder {
        private int id;
        private String name;
        private String description;
        private String country;
        private String city;
        private int star;
        private String website;
        private int averageRating;
        private ArrayList<HotelReview> hotelReview = new ArrayList<HotelReview>();

        private HotelBuilder() {
        }

        public static HotelBuilder aHotel() {
            return new HotelBuilder();
        }

        public HotelBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public HotelBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public HotelBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public HotelBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public HotelBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public HotelBuilder withStar(int star) {
            this.star = star;
            return this;
        }

        public HotelBuilder withWebsite(String website) {
            this.website = website;
            return this;
        }

        public HotelBuilder withAverageRating(int averageRating) {
            this.averageRating = averageRating;
            return this;
        }

        public HotelBuilder withHotelReview(ArrayList<HotelReview> hotelReview) {
            this.hotelReview = hotelReview;
            return this;
        }

        public Hotel build() {
            Hotel hotel = new Hotel();
            hotel.setId(id);
            hotel.setName(name);
            hotel.setDescription(description);
            hotel.setCountry(country);
            hotel.setCity(city);
            hotel.setStar(star);
            hotel.setWebsite(website);
            hotel.setAverageRating(averageRating);
            hotel.hotelReview = this.hotelReview;
            return hotel;
        }
    }
}
