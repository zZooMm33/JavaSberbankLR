package storage.hotel;

/**
 * Сущность отеля
 */
public class Hotel {

    /**
     * id отеля
     */
    private int id;
    /**
     * Название
     */
    private String name;
    /**
     * Описание
     */
    private String description;
    /**
     * Страна расположения
     */
    private String country;
    /**
     * Город расположения
     */
    private String city;
    /**
     * Количество звезд
     */
    private int star;
    /**
     * Веб сайт отеля
     */
    private String website;

    /**
     * Вернет id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Сохранит id
     * @param id id отеля
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Вернет название отеля
     * @return название отеля
     */
    public String getName() {
        return name;
    }

    /**
     * Сохранит название отеля
     * @param name название отеля
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Вернет описание отеля
     * @return описание отеля
     */
    public String getDescription() {
        return description;
    }

    /**
     * Сохранит описание отеля
     * @param description описание отеля
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Вернет страну расположения отеля
     * @return название страны
     */
    public String getCountry() {
        return country;
    }

    /**
     * Сохранит страну расположения отеля
     * @param country название страны
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Вернет город расположения отеля
     * @return название города
     */
    public String getCity() {
        return city;
    }

    /**
     * Сохранит город расположения отеля
     * @param city город
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Вернет кол-во звезд отеля
     * @return кол-во звезд
     */
    public int getStar() {
        return star;
    }

    /**
     * Сохранит кол-во звезд отеля
     * @param star кол-во звезд
     */
    public void setStar(int star) {
        this.star = star;
    }

    /**
     * Вернет сайт отеля
     * @return сайт отеля
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Сохранит сайт отеля
     * @param website сайт отеля
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Метод для создания билдера
     *
     * @return
     */
    public static Builder newBuilder() {
        return new Hotel().new Builder();
    }

    /**
     * Паттерн билдер
     */
    public class Builder{
        public Builder setId(int id) {
            Hotel.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Hotel.this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            Hotel.this.description = description;
            return this;
        }

        public Builder setCountry(String country) {
            Hotel.this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            Hotel.this.city = city;
            return this;
        }

        public Builder setStar(int star) {
            Hotel.this.star = star;
            return this;
        }

        public Builder setWebsite(String website) {
            Hotel.this.website = website;
            return this;
        }

        public Hotel Build(){
            Hotel hotel = new Hotel();

            hotel.setId(Hotel.this.id);
            hotel.setName(Hotel.this.name);
            hotel.setDescription(Hotel.this.description);
            hotel.setCountry(Hotel.this.country);
            hotel.setCity(Hotel.this.city);
            hotel.setStar(Hotel.this.star);
            hotel.setWebsite(Hotel.this.website);

            return hotel;
        }
    }
}
