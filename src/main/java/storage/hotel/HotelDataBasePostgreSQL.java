package storage.hotel;

import storage.ConnectionDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelDataBasePostgreSQL implements HotelDAO {
    @Override
    public ArrayList<Hotel> getAllHotels(){

        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        Statement statement = null;

        try
        {
            ResultSet resultSet = null;
            statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery("select H.id, H.name, H.country, H.city, H.website, coalesce(HW.avg, 0) as averageRating from " +
                    "(SELECT ID, NAME, COUNTRY, CITY, WEBSITE FROM hotel) H " +
                    "left outer join " +
                    "(SELECT id_hotel, avg(rating) as AVG FROM hotel_review GROUP BY id_hotel) HW " +
                    "on H.ID = HW.id_hotel GROUP BY H.id, h.name, h.country, h.website, h.city, hw.AVG ORDER BY h.name");

            while (resultSet.next())
            {
                hotels.add(Hotel.HotelBuilder.aHotel()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withCountry(resultSet.getString("COUNTRY"))
                        .withCity(resultSet.getString("CITY"))
                        .withWebsite(resultSet.getString("WEBSITE"))
                        .withAverageRating(resultSet.getInt("averageRating"))
                        .build());
            }

        } catch (SQLException e)
        {
            e.printStackTrace();

        }

        ConnectionDataBase.closeConnection();
        return hotels;
    }

    @Override
    public Hotel getHotelByName(String name) {

        Hotel hotel =null;

        try
        {
            ResultSet resultSet = null;
            Statement statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format("SELECT * FROM hotel WHERE NAME = '%s';\n", name));

            while (resultSet.next()){
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
        } catch (SQLException e)
        {

            e.printStackTrace();

        }

        ConnectionDataBase.closeConnection();
        return hotel;
    }

    @Override
    public Hotel getHotelById(int id) {

        Hotel hotel = null;

        try
        {
            System.out.println("SELECT");
            ResultSet resultSet;
            Statement statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format("SELECT * FROM hotel WHERE id = %d;\n", id));
            System.out.println("SELECT * FROM hotel WHERE id = " + id + ";\n");
            while (resultSet.next()){
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

        } catch (SQLException e)
        {
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
