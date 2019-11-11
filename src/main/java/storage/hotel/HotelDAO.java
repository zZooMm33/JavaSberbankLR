package storage.hotel;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Интерфейс отеля
 */
public interface HotelDAO {

    /**
     * Список отелей
     * @return список отелей
     */
    ArrayList<Hotel> getAllHotels();

    /**
     * Вернет информация об отеле по имени
     * @param name имя отеля
     * @return отель
     */
    Hotel getHotelByName(String name);

    /**
     * Вернет информация об отеле по id
     * @param id id отеля
     * @return отель
     */
    Hotel getHotelById(int id);

    /**
     * Обновить отель
     * @param hotel новый отель
     * @return удалось ли обновить
     */
    boolean updateHotelById(Hotel hotel);
}
