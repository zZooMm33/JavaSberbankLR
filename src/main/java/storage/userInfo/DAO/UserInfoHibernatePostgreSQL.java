package storage.userInfo.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import storage.ConnectionHibernate;
import storage.userInfo.UserInfo;
import storage.userPass.UserPass;
import storage.userToken.UserToken;

public class UserInfoHibernatePostgreSQL implements UserInfoDAO {
    @Override
    public boolean addUserInfo(UserInfo userInfo, UserPass userPass, UserToken userToken) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();

            session.save(userInfo);

            userPass.setUser(userInfo);
            session.save(userPass);

            userToken.setUser(userInfo);
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
    public boolean changeUserInfo(UserInfo userInfo) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        UserInfo oldUserInfo = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(UserInfo.class);
            criteria.add(Restrictions.eq("mail", userInfo.getMail()));

            oldUserInfo = (UserInfo) criteria.list().get(0);
            oldUserInfo.setMail(userInfo.getMail());
            oldUserInfo.setFirstName(userInfo.getFirstName());
            oldUserInfo.setLastName(userInfo.getLastName());
            oldUserInfo.setDateOfBirth(userInfo.getDateOfBirth());
            oldUserInfo.setSex(userInfo.getSex());

            session.update(oldUserInfo);
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
    public UserInfo getUserInfoByToken(String token) {

        return null;
    }

    @Override
    public UserInfo getUserInfoByMail(String mail) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        UserInfo userInfo = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(UserInfo.class);
            criteria.add(Restrictions.eq("mail", mail));

            userInfo = (UserInfo) criteria.list().get(0);

            session.getTransaction().commit();
            session.close();
            return userInfo;
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
