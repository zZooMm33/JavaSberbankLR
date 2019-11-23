package storage.userInfo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import storage.ConnectionHibernate;
import storage.userInfo.UserInfo;
import storage.userPass.UserPass;
import storage.userToken.UserToken;

import java.util.UUID;

public class UserInfoHibernatePostgreSQL implements UserInfoDAO {
    @Override
    public boolean addUserInfo(UserInfo userInfo, UserPass userPass) {
        SessionFactory sessionFactory = ConnectionHibernate.getConnection();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();

            session.save(userInfo);

            userPass.setUser(userInfo);
            session.save(userPass);

            UserToken userToken = UserToken.UserTokenBuilder.anUserToken()
                    .withUser(userInfo)
                    .withToken(UUID.randomUUID().toString())
                    .build();
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
        return false;
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        return null;
    }

    @Override
    public UserInfo getUserInfoByMail(String mail) {
        return null;
    }
}
