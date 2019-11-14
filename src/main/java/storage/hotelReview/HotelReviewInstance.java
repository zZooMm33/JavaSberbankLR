package storage.hotelReview;

/**
 * Синглтон для работы с HotelReview
 */
public class HotelReviewInstance {
    /**
     * Синглтон комментариев отеля
     */
    private static HotelReviewDAO hotelReviewInstance = null;

    /**
     * Получение / создание сущности комментариев отеля
     * @return HotelReview
     */
    public static HotelReviewDAO getHotelReviewInstance(){
        if (hotelReviewInstance == null) hotelReviewInstance = new HotelReviewFactory().factoryMethod();
        return hotelReviewInstance;
    }
}
