package storage.hotelReview;

import java.util.ArrayList;

public interface HotelReviewDAO {
    public ArrayList<HotelReview> getHotelReviewByUserId(int idUser);

    public ArrayList<HotelReview> getHotelReviewByHotelId(int idHotel);

    public boolean deleteHotelReviewByUserId(int id);

    public boolean updateHotelReviewByUserId(HotelReview hotelReview);

    public boolean addHotelReviewByUserId(HotelReview hotelReview);
}
