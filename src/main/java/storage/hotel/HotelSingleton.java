package storage.hotel;

/**
 * Синглтон для работы с сущностью отеля
 */
public class HotelSingleton {
    private static HotelDAO hotelSingleton = null;

    public static HotelDAO getHotelSingleton(){
        if (hotelSingleton == null) hotelSingleton = new HotelFactory().factoryMethod();
        return hotelSingleton;
    }
}
