package storage.hotelReview.DAO;

import storage.ConnectionDataBase;
import storage.hotelReview.HotelReview;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HotelReviewJDBCPostgreSQL implements HotelReviewDAO {

    private static final String REQUEST_GET_HOTEL_REVIEW_BY_USER_ID = "SELECT * FROM HOTEL_REVIEW where ID_USER = %d;\n";

    private static final String REQUEST_GET_HOTEL_REVIEW_BY_HOTEL_ID = "SELECT DATE_OF_VISIT, RATING, DESCRIPTION, UI.date_of_birth FROM HOTEL_REVIEW, (SELECT * FROM user_info) UI where ID_HOTEL = %d AND ID_USER = UI.id;\n";

    @Override
    public ArrayList<HotelReview> getHotelReviewByUserId(int idUser) {
        ArrayList<HotelReview> hotelReviews = new ArrayList<HotelReview>();
        Statement statement = null;

        try {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format(REQUEST_GET_HOTEL_REVIEW_BY_USER_ID, idUser));

            while (resultSet.next()) {

                hotelReviews.add(HotelReview.HotelReviewBuilder.aHotelReview()
                        .withId(resultSet.getInt("ID"))
                        .withIdUser(resultSet.getInt("ID_USER"))
                        .withIdHotel(resultSet.getInt("ID_HOTEL"))
                        .withDateOfVisit(resultSet.getString("DATE_OF_VISIT"))
                        .withRating(resultSet.getInt("RATING"))
                        .withDescription(resultSet.getString("DESCRIPTION"))
                        .build());
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        ConnectionDataBase.closeConnection();
        return hotelReviews;
    }

    @Override
    public ArrayList<HotelReview> getHotelReviewByHotelId(int idHotel) {
        ArrayList<HotelReview> hotelReviews = new ArrayList<HotelReview>();
        Statement statement = null;

        try {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format(REQUEST_GET_HOTEL_REVIEW_BY_HOTEL_ID, idHotel));

            while (resultSet.next()) {
                HotelReview hotelReview = HotelReview.HotelReviewBuilder.aHotelReview()
                        .withDateOfVisit(resultSet.getString("DATE_OF_VISIT"))
                        .withRating(resultSet.getInt("RATING"))
                        .withDescription(resultSet.getString("DESCRIPTION"))
                        .build();

                // находим возраст пользователя на момент посещения отеля
                try {

                    Date dateOfBirthUser = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("DATE_OF_BIRTH")),
                            dateOfVisit = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("DATE_OF_VISIT"));

                    int userAgeOfVisit = (int) ((dateOfVisit.getTime() - dateOfBirthUser.getTime()) / (24 * 60 * 60 * 1000)) / 365;
                    hotelReview.setUserAgeOfVisit(Integer.toString(userAgeOfVisit));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                hotelReviews.add(hotelReview);
            }


        } catch (SQLException e) {
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
