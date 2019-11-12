package storage.userToken;

public interface UserTokenDAO {
    public boolean addUserToken(UserToken userToken);
    public boolean deleteUserTokenByToken(String token);
    public boolean changeUserToken(UserToken userToken);
}
