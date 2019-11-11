package storage.hotel;

/**
 * Синглтон для работы с сущностью отеля
 */
public class HotelInstance {
    /**
     * Синглтон отеля
     */
    private static HotelDAO hotelInstance = null;

    /**
     * Получение / создание отеля
     * @return отель
     */
    public static HotelDAO getHotelInstance(){
        if (hotelInstance == null) hotelInstance = new HotelFactory().factoryMethod();
        return hotelInstance;
    }
}
