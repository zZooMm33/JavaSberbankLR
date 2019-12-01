package storage.hotel.DAO;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import storage.ConnectionHibernate;
import storage.hotel.Hotel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HotelHibernatePostgreSQL implements HotelDAO {

    private static final String REQUEST_GET_ALL_HOTELS = "select H.id, H.name, H.country, H.city, H.website, coalesce(HW.avg, 0) as averageRating, H.star, H.description from \n" +
            "(SELECT * FROM hotel) H \n" +
            "left outer join \n" +
            "(SELECT hotel_id, avg(rating) as AVG FROM hotel_review GROUP BY hotel_id) HW \n" +
            "on H.ID = HW.hotel_id GROUP BY H.id, h.name, h.country, h.website, h.city, hw.AVG, H.star, H.description ORDER BY h.name";

    @Override
    public Set<Hotel> getAllHotels() {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        Set<Hotel> hotels = new HashSet<Hotel>();
        try{
            session.beginTransaction();

            SQLQuery sqlQuery = session.createSQLQuery(REQUEST_GET_ALL_HOTELS);
            //sqlQuery.addEntity("H", Hotel.class);
            //hotels = new HashSet<Hotel>(sqlQuery.list());

            List<Object[]> rows = sqlQuery.list();
            for(Object[] row : rows){

                hotels.add(Hotel.HotelBuilder.aHotel()
                        .withId(Integer.parseInt(row[0].toString()))
                        .withName(row[1].toString())
                        .withCountry(row[2].toString())
                        .withCity(row[3].toString())
                        .withWebsite(row[4].toString())
                        .withAverageRating(Double.parseDouble(row[5].toString()))
                        .withStar(Integer.parseInt(row[6].toString()))
                        .withDescription(row[7].toString())
                        .build());
            }

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return hotels;
    }

    @Override
    public Hotel getHotelByName(String name) {
        return null;
    }

    @Override
    public Hotel getHotelById(int id) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        Hotel hotel = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Hotel.class);
            criteria.add(Restrictions.idEq(id));

            hotel = (Hotel) criteria.list().get(0);

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return hotel;
    }

    @Override
    public boolean updateHotelById(Hotel hotel) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        Hotel oldHotel = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Hotel.class);
            criteria.add(Restrictions.idEq(hotel.getId()));

            oldHotel = (Hotel) criteria.list().get(0);
            oldHotel.setCity(hotel.getCity());
            oldHotel.setCountry(hotel.getCountry());
            oldHotel.setWebsite(hotel.getWebsite());
            oldHotel.setDescription(hotel.getDescription());
            oldHotel.setName(hotel.getName());
            oldHotel.setStar(hotel.getStar());

            session.update(oldHotel);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
}
