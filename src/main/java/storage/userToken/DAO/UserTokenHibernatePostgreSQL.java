package storage.userToken.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import storage.ConnectionHibernate;
import storage.userInfo.UserInfo;
import storage.userToken.UserToken;

public class UserTokenHibernatePostgreSQL implements UserTokenDAO {
    @Override
    public boolean addUserToken(UserToken userToken) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();

            session.save(userToken);
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
    public boolean deleteUserTokenByToken(String token) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        UserToken userToken = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(UserToken.class);
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("token", token));

            userToken = (UserToken) criteria.list().get(0);
            session.delete(userToken);

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
    public boolean changeUserToken(UserToken userToken) {
        return false;
    }

    @Override
    public boolean deleteUserTokenByUserId(int idUser) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        UserToken userToken = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(UserToken.class);
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("user.id", idUser));

            userToken = (UserToken) criteria.list().get(0);
            session.delete(userToken);

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public UserInfo getUserInfoByToken(String token) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        UserToken userToken = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(UserToken.class);
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("token", token));

            userToken = (UserToken) criteria.list().get(0);

            session.getTransaction().commit();
            session.close();
            return userToken.getUser();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
