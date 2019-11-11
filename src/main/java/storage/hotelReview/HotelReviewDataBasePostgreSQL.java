package storage.hotelReview;

import storage.ConnectionDataBase;
import storage.hotel.Hotel;

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

            resultSet = statement.executeQuery(String.format("SELECT * FROM HOTEL_REVIEW where ID_USER + '%d';\n", idUser));

            while (resultSet.next())
            {

                hotelReviews.add(HotelReview.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setIdUser(resultSet.getInt("ID_USER"))
                        .setIdHotel(resultSet.getInt("ID_HOTEL"))
                        .setDateOfVisit(resultSet.getString("DATE_OF_VISIT"))
                        .setRating(resultSet.getInt("RATING"))
                        .setDescription(resultSet.getString("DESCRIPTION"))
                        .Build());
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return hotelReviews;
        }
        finally {
            ConnectionDataBase.closeConnection();
            return hotelReviews;
        }
    }

    @Override
    public ArrayList<HotelReview> getHotelReviewByHotelId(int idHotel) {
        ArrayList<HotelReview> hotelReviews = new ArrayList<HotelReview>();
        Statement statement = null;

        try
        {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format("SELECT * FROM HOTEL_REVIEW where ID_USER + '%d';\n", idHotel));

            while (resultSet.next())
            {

                hotelReviews.add(HotelReview.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setIdUser(resultSet.getInt("ID_USER"))
                        .setIdHotel(resultSet.getInt("ID_HOTEL"))
                        .setDateOfVisit(resultSet.getString("DATE_OF_VISIT"))
                        .setRating(resultSet.getInt("RATING"))
                        .setDescription(resultSet.getString("DESCRIPTION"))
                        .Build());
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return hotelReviews;
        }
        finally {
            ConnectionDataBase.closeConnection();
            return hotelReviews;
        }
    }

    @Override
    public boolean deleteHotelReviewByUserId(int id) {
        return false;
    }

    @Override
    public boolean updateHotelReviewByUserId(HotelReview hotelReview) {
        return false;
    }

    @Override
    public boolean addHotelReviewByUserId(HotelReview hotelReview) {
        return false;
    }
}
