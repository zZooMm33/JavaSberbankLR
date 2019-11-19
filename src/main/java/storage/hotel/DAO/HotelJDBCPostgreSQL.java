package storage.hotel.DAO;

import storage.ConnectionDataBase;
import storage.hotel.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelJDBCPostgreSQL implements HotelDAO {

    private static final String REQUEST_GET_ALL_HOTELS = "select H.id, H.name, H.country, H.city, H.website, coalesce(HW.avg, 0) as averageRating from \n" +
            "(SELECT ID, NAME, COUNTRY, CITY, WEBSITE FROM hotel) H \n" +
            "left outer join \n" +
            "(SELECT id_hotel, avg(rating) as AVG FROM hotel_review GROUP BY id_hotel) HW \n" +
            "on H.ID = HW.id_hotel GROUP BY H.id, h.name, h.country, h.website, h.city, hw.AVG ORDER BY h.name";

    private static final String REQUEST_GET_HOTEL_BY_NAME = "SELECT * FROM hotel WHERE NAME = '%s';\n";

    private static final String REQUEST_GET_HOTEL_BY_ID = "SELECT * FROM hotel WHERE id = %d;\n";

    @Override
    public ArrayList<Hotel> getAllHotels() {

        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        Statement statement = null;

        try {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(REQUEST_GET_ALL_HOTELS);

            while (resultSet.next()) {
                hotels.add(Hotel.HotelBuilder.aHotel()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withCountry(resultSet.getString("COUNTRY"))
                        .withCity(resultSet.getString("CITY"))
                        .withWebsite(resultSet.getString("WEBSITE"))
                        .withAverageRating(resultSet.getInt("averageRating"))
                        .build());
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        ConnectionDataBase.closeConnection();
        return hotels;
    }

    @Override
    public Hotel getHotelByName(String name) {

        Hotel hotel = null;

        try {
            ResultSet resultSet = null;
            Statement statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format(REQUEST_GET_HOTEL_BY_NAME, name));

            while (resultSet.next()) {
                hotel = Hotel.HotelBuilder.aHotel()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withDescription(resultSet.getString("DESCRIPTION"))
                        .withCountry(resultSet.getString("COUNTRY"))
                        .withCity(resultSet.getString("CITY"))
                        .withStar(resultSet.getInt("STAR"))
                        .withWebsite(resultSet.getString("WEBSITE"))
                        .build();
            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

        ConnectionDataBase.closeConnection();
        return hotel;
    }

    @Override
    public Hotel getHotelById(int id) {

        Hotel hotel = null;

        try {
            ResultSet resultSet;
            Statement statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format(REQUEST_GET_HOTEL_BY_ID, id));
            while (resultSet.next()) {
                hotel = Hotel.HotelBuilder.aHotel()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withDescription(resultSet.getString("DESCRIPTION"))
                        .withCountry(resultSet.getString("COUNTRY"))
                        .withCity(resultSet.getString("CITY"))
                        .withStar(resultSet.getInt("STAR"))
                        .withWebsite(resultSet.getString("WEBSITE"))
                        .build();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        ConnectionDataBase.closeConnection();
        return hotel;
    }

    @Override
    public boolean updateHotelById(Hotel hotel) {
        return false;
    }
}
