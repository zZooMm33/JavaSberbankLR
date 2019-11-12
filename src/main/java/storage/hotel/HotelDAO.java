package storage.hotel;

import java.util.ArrayList;

/**
 * Интерфейс отеля
 */
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

    /**
     * Обновить отель
     * @param hotel новый отель
     * @return удалось ли обновить
     */
    public boolean updateHotelById(Hotel hotel);
}
