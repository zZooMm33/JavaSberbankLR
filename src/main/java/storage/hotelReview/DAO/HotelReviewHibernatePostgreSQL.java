package storage.hotelReview.DAO;

import storage.hotelReview.HotelReview;

import java.util.ArrayList;

public class HotelReviewHibernatePostgreSQL implements HotelReviewDAO {
    @Override
    public ArrayList<HotelReview> getHotelReviewByUserId(int idUser) {
        return null;
    }

    @Override
    public ArrayList<HotelReview> getHotelReviewByHotelId(int idHotel) {
        return null;
    }

    @Override
    public boolean deleteHotelReviewById(int id) {
        return false;
    }

    @Override
    public boolean updateHotelReviewById(HotelReview hotelReview) {
        return false;
    }

    @Override
    public boolean addHotelReviewByUserId(HotelReview hotelReview) {
        return false;
    }
}
