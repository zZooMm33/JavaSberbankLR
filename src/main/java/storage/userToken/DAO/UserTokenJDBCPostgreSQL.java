package storage.userToken.DAO;

import storage.userInfo.UserInfo;
import storage.userToken.UserToken;

public class UserTokenJDBCPostgreSQL implements UserTokenDAO {
    @Override
    public boolean addUserToken(UserToken userToken) {
        return false;
    }

    @Override
    public boolean deleteUserTokenByToken(String token) {
        return false;
    }

    @Override
    public boolean changeUserToken(UserToken userToken) {
        return false;
    }

    @Override
    public boolean deleteUserTokenByUserId(int idUser) {
        return false;
    }

    @Override
    public UserInfo getUserInfoByToken(String token) {
        return null;
    }
}
