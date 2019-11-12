package storage.userInfo;

public interface UserInfoDAO {

    public boolean addUserInfo(UserInfo userInfo);

    public boolean changeUserInfo(UserInfo userInfo);

    public UserInfo getUserInfoById(int id);

    public UserInfo getUserInfoByMail(String mail);
}
