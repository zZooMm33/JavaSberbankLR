package storage.hotelReview;

/**
 * Синглтон для работы с сущностью комментариев отеля
 */
public class HotelReviewInstance {
    /**
     * Синглтон комментариев отеля
     */
    private static HotelReviewDAO hotelInstance = null;

    /**
     * Получение / создание сущности комментариев отеля
     * @return отель
     */
    public static HotelReviewDAO getHotelInstance(){
        if (hotelInstance == null) hotelInstance = new HotelReviewFactory().factoryMethod();
        return hotelInstance;
    }
}
