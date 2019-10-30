package storage.hotel;

import java.util.ArrayList;

public interface HotelDAO {

    /**
     * Список отелей
     * @return список отелей
     */
    public ArrayList<Hotel> getAllHotels();

    /**
     * Вернет информация об отеле по имени
     * @param name имя отеля
     * @return отель
     */
    public Hotel getHotelByName(String name);

    /**
     * Вернет информация об отеле по id
     * @param id id отеля
     * @return отель
     */
    public Hotel getHotelById(int id);
}
