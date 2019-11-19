package storage.hotelReview.DAO;

import storage.hotelReview.HotelReview;

import java.util.ArrayList;

/**
 * Интерфейс сущности HotelReview
 */
public interface HotelReviewDAO {

    /**
     * Получить список HotelReview по id пользователя
     *
     * @param idUser id пользователя
     * @return ArrayList<HotelReview>
     */
    public ArrayList<HotelReview> getHotelReviewByUserId(int idUser);

    /**
     * Получить список HotelReview по id отеля
     *
     * @param idHotel id отеля
     * @return ArrayList<HotelReview>
     */
    public ArrayList<HotelReview> getHotelReviewByHotelId(int idHotel);

    /**
     * Удалить HotelReview по id
     *
     * @param id id HotelReview
     * @return удалось удалить или нет
     */
    public boolean deleteHotelReviewById(int id);

    /**
     * Изменить hotelReview
     *
     * @param hotelReview hotelReview
     * @return удалось изменить или нет
     */
    public boolean updateHotelReviewById(HotelReview hotelReview);

    /**
     * Добавить новый hotelReview
     *
     * @param hotelReview hotelReview
     * @return удалось добавить или нет
     */
    public boolean addHotelReviewByUserId(HotelReview hotelReview);
}
