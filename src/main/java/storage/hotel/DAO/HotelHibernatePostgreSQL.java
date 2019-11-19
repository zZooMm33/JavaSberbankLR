package storage.hotel.DAO;

import org.hibernate.SessionFactory;
import storage.ConnectionHibernate;
import storage.hotel.Hotel;

import java.util.ArrayList;

public class HotelHibernatePostgreSQL implements HotelDAO {
    @Override
    public ArrayList<Hotel> getAllHotels() {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();

        return null;
    }

    @Override
    public Hotel getHotelByName(String name) {
        return null;
    }

    @Override
    public Hotel getHotelById(int id) {
        return null;
    }

    @Override
    public boolean updateHotelById(Hotel hotel) {
        return false;
    }
}
