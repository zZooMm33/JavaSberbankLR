package storage.hotelReview;

import storage.ConnectionDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class HotelReviewDataBasePostgreSQL implements HotelReviewDAO {
    @Override
    public ArrayList<HotelReview> getHotelReviewByUserId(int idUser) {
        ArrayList<HotelReview> hotelReviews = new ArrayList<HotelReview>();
        Statement statement = null;

        try
        {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format("SELECT * FROM HOTEL_REVIEW where ID_USER = %d;\n", idUser));

            while (resultSet.next())
            {

                hotelReviews.add(HotelReview.HotelReviewBuilder.aHotelReview()
                        .withId(resultSet.getInt("ID"))
                        .withIdUser(resultSet.getInt("ID_USER"))
                        .withIdHotel(resultSet.getInt("ID_HOTEL"))
                        .withDateOfVisit(resultSet.getString("DATE_OF_VISIT"))
                        .withRating(resultSet.getInt("RATING"))
                        .withDescription(resultSet.getString("DESCRIPTION"))
                        .build());
            }

        } catch (SQLException e)
        {

            e.printStackTrace();

        }

        ConnectionDataBase.closeConnection();
        return hotelReviews;
    }

    @Override
    public ArrayList<HotelReview> getHotelReviewByHotelId(int idHotel) {
        ArrayList<HotelReview> hotelReviews = new ArrayList<HotelReview>();
        Statement statement = null;

        try
        {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format("SELECT * FROM HOTEL_REVIEW where ID_HOTEL = %d;\n", idHotel));

            while (resultSet.next())
            {
                hotelReviews.add(HotelReview.HotelReviewBuilder.aHotelReview()
                        .withId(resultSet.getInt("ID"))
                        .withIdUser(resultSet.getInt("ID_USER"))
                        .withIdHotel(resultSet.getInt("ID_HOTEL"))
                        .withDateOfVisit(resultSet.getString("DATE_OF_VISIT"))
                        .withRating(resultSet.getInt("RATING"))
                        .withDescription(resultSet.getString("DESCRIPTION"))
                        .build());
            }



        } catch (SQLException e)
        {
            e.printStackTrace();

        }

        ConnectionDataBase.closeConnection();
        return hotelReviews;
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
