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

            resultSet = statement.executeQuery("SELECT * FROM hotel;\n");

            while (resultSet.next())
            {

                hotels.add(Hotel.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setName(resultSet.getString("NAME"))
                        .setDescription(resultSet.getString("DESCRIPTION"))
                        .setCountry(resultSet.getString("COUNTRY"))
                        .setCity(resultSet.getString("CITY"))
                        .setStar(resultSet.getInt("STAR"))
                        .setWebsite(resultSet.getString("WEBSITE"))
                        .Build());
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return hotels;
        }
        finally {
            ConnectionDataBase.closeConnection();
            return hotels;
        }
    }

    @Override
    public Hotel getHotelByName(String name) {
        try
        {
            ResultSet resultSet = null;
            Statement statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format("SELECT * FROM hotel WHERE NAME = '%s';\n", name));

            while (resultSet.next())
            {
                return Hotel.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setName(resultSet.getString("NAME"))
                        .setDescription(resultSet.getString("DESCRIPTION"))
                        .setCountry(resultSet.getString("COUNTRY"))
                        .setCity(resultSet.getString("CITY"))
                        .setStar(resultSet.getInt("STAR"))
                        .setWebsite(resultSet.getString("WEBSITE"))
                        .Build();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally {
            ConnectionDataBase.closeConnection();
            return null;
        }
    }

    @Override
    public Hotel getHotelById(int id) {
        try
        {
            ResultSet resultSet = null;
            Statement statement = ConnectionDataBase.getConnection().createStatement();

            resultSet = statement.executeQuery(String.format("SELECT * FROM hotel WHERE id = '%d';\n", id));

            while (resultSet.next())
            {
                return Hotel.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setName(resultSet.getString("NAME"))
                        .setDescription(resultSet.getString("DESCRIPTION"))
                        .setCountry(resultSet.getString("COUNTRY"))
                        .setCity(resultSet.getString("CITY"))
                        .setStar(resultSet.getInt("STAR"))
                        .setWebsite(resultSet.getString("WEBSITE"))
                        .Build();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally {
            ConnectionDataBase.closeConnection();
            return null;
        }
    }

    @Override
    public boolean updateHotelById(Hotel hotel) {
        return false;
    }
}
