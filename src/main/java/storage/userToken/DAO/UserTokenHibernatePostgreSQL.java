package storage.userToken.DAO;

import storage.userToken.UserToken;

public class UserTokenHibernatePostgreSQL implements UserTokenDAO {
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
}
