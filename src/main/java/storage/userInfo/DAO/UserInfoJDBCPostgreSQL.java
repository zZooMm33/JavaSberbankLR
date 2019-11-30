package storage.userInfo.DAO;

import storage.userInfo.UserInfo;
import storage.userPass.UserPass;

public class UserInfoJDBCPostgreSQL implements UserInfoDAO {

    @Override
    public boolean addUserInfo(UserInfo userInfo, UserPass userPass, storage.userToken.UserToken userToken) {
        return false;
    }

    @Override
    public boolean changeUserInfo(UserInfo userInfo) {
        return false;
    }

    @Override
    public UserInfo getUserInfoByToken(String token) {
        return null;
    }

    @Override
    public UserInfo getUserInfoByMail(String mail) {
        return null;
    }
}
