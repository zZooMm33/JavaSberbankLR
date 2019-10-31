package storage.hotel;

/**
 * Синглтон для работы с сущностью отеля
 */
public class HotelSingleton {
    /**
     * Синглтон отеля
     */
    private static HotelDAO hotelSingleton = null;

    /**
     * Получение / создание отеля
     * @return отель
     */
    public static HotelDAO getHotelSingleton(){
        if (hotelSingleton == null) hotelSingleton = new HotelFactory().factoryMethod();
        return hotelSingleton;
    }
}
