package storage.userToken;

public class UserTokenDataBasePostgreSQL implements UserTokenDAO {
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
