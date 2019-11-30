package storage.userPass.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import storage.ConnectionHibernate;
import storage.userPass.UserPass;

public class UserPassHibernatePostgreSQL implements UserPassDAO {
    @Override
    public boolean addUserPass(UserPass userPass) {
        return false;
    }

    @Override
    public boolean changeUserPass(UserPass userPass) {
        return false;
    }

    @Override
    public UserPass getUserPassByUserId(int userId) {

        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();
        UserPass userPass = null;
        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(UserPass.class);
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("user.id", userId));

            userPass = (UserPass) criteria.list().get(0);

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return userPass;

    }
}
