package storage.userInfo.DAO;

import storage.userInfo.UserInfo;
import storage.userPass.UserPass;

public class UserInfoJDBCPostgreSQL implements UserInfoDAO {
    @Override
    public boolean addUserInfo(UserInfo userInfo, UserPass userPass) {
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
