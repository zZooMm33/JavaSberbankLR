package storage.hotelReview.DAO;

import storage.ConnectionDataBase;
import storage.hotelReview.HotelReview;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class HotelReviewJDBCPostgreSQL implements HotelReviewDAO {

    private static final String REQUEST_GET_HOTEL_REVIEW_BY_USER_ID = "SELECT * FROM HOTEL_REVIEW where idUSER = %d;\n";

    private static final String REQUEST_GET_HOTEL_REVIEW_BY_HOTEL_ID = "SELECT DATEOFVISIT, RATING, DESCRIPTION, UI.dateofbirth FROM HOTEL_REVIEW, (SELECT * FROM user_info) UI where hotel_id = %d AND user_id = UI.id;\n";

    @Override
    public Set<HotelReview> getHotelReviewByUserId(int idUser) {
        Set<HotelReview> hotelReviews = new HashSet<HotelReview>();
        Statement statement = null;

        try {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format(REQUEST_GET_HOTEL_REVIEW_BY_USER_ID, idUser));

            while (resultSet.next()) {

                hotelReviews.add(HotelReview.HotelReviewBuilder.aHotelReview()
                        .withId(resultSet.getInt("ID"))
                        .withDateOfVisit(resultSet.getString("DATEOFVISIT"))
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
    public Set<HotelReview> getHotelReviewByHotelId(int idHotel) {
        Set<HotelReview> hotelReviews = new HashSet<HotelReview>();
        Statement statement = null;

        try {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format(REQUEST_GET_HOTEL_REVIEW_BY_HOTEL_ID, idHotel));

            while (resultSet.next()) {
                HotelReview hotelReview = HotelReview.HotelReviewBuilder.aHotelReview()
                        .withDateOfVisit(resultSet.getString("DATEOFVISIT"))
                        .withRating(resultSet.getInt("RATING"))
                        .withDescription(resultSet.getString("DESCRIPTION"))
                        .build();

                // находим возраст пользователя на момент посещения отеля
                try {

                    Date dateOfBirthUser = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("DATEOFBIRTH")),
                            dateOfVisit = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("DATEOFVISIT"));

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
