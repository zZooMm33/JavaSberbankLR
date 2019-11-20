package storage.userInfo.DAO;

import org.apache.log4j.Logger;
import storage.hotel.DAO.HotelHibernatePostgreSQL;
import storage.userInfo.UserInfo;

public class UserInfoHibernatePostgreSQL implements UserInfoDAO {
    private static final Logger logger = Logger.getLogger(HotelHibernatePostgreSQL.class);

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        return false;
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
