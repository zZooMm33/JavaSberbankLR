package storage.hotelReview.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import storage.ConnectionHibernate;
import storage.hotelReview.HotelReview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HotelReviewHibernatePostgreSQL implements HotelReviewDAO {

    @Override
    public Set<HotelReview> getHotelReviewByUserId(int idUser) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        Set<HotelReview> hotelReviews = new HashSet<HotelReview>();
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(HotelReview.class);
            criteria.createAlias("hotel", "hotel");
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("user.id", idUser));

            hotelReviews = new HashSet<HotelReview>(criteria.list());

            for(HotelReview hotelReview : hotelReviews){
                // находим возраст пользователя на момент посещения отеля
                try {

                    Date dateOfBirthUser = new SimpleDateFormat("yyyy-MM-dd").parse(hotelReview.getUser().getDateOfBirth()),
                            dateOfVisit = new SimpleDateFormat("yyyy-MM-dd").parse(hotelReview.getDateOfVisit());

                    int userAgeOfVisit = (int) ((dateOfVisit.getTime() - dateOfBirthUser.getTime()) / (24 * 60 * 60 * 1000)) / 365;
                    hotelReview.setUserAgeOfVisit(Integer.toString(userAgeOfVisit));
                } catch (ParseException e) {
                    //e.printStackTrace();
                    hotelReview.setUserAgeOfVisit(null);
                }
            }

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return hotelReviews;
    }

    @Override
    public Set<HotelReview> getHotelReviewByHotelId(int idHotel) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        Set<HotelReview> hotelReviews = new HashSet<HotelReview>();
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(HotelReview.class);
            criteria.createAlias("hotel", "hotel");
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("hotel.id", idHotel));

            hotelReviews = new HashSet<HotelReview>(criteria.list());

            for(HotelReview hotelReview : hotelReviews){
                // находим возраст пользователя на момент посещения отеля
                try {

                    Date dateOfBirthUser = new SimpleDateFormat("yyyy-MM-dd").parse(hotelReview.getUser().getDateOfBirth()),
                            dateOfVisit = new SimpleDateFormat("yyyy-MM-dd").parse(hotelReview.getDateOfVisit());

                    int userAgeOfVisit = (int) ((dateOfVisit.getTime() - dateOfBirthUser.getTime()) / (24 * 60 * 60 * 1000)) / 365;
                    hotelReview.setUserAgeOfVisit(Integer.toString(userAgeOfVisit));
                } catch (ParseException e) {
                    e.printStackTrace();
                    hotelReview.setUserAgeOfVisit(null);
                }
            }

            session.getTransaction().commit();
            session.close();

        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return hotelReviews;
    }

    @Override
    public boolean deleteHotelReviewById(int id) {
        return false;
    }

    @Override
    public boolean updateHotelReviewById(HotelReview hotelReview) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        HotelReview oldHotelReview = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(HotelReview.class);
            criteria.createAlias("hotel", "hotel");
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.idEq(hotelReview.getId()));

            oldHotelReview = (HotelReview) criteria.list().get(0);
            oldHotelReview.setRating(hotelReview.getRating());
            oldHotelReview.setDateOfVisit(hotelReview.getDateOfVisit());
            oldHotelReview.setDescription(hotelReview.getDescription());

            session.update(oldHotelReview);
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

    @Override
    public boolean addHotelReviewByUserId(HotelReview hotelReview) {
        return false;
    }
}
