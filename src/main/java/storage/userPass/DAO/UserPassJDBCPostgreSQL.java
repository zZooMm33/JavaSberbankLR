package storage.userPass.DAO;

import storage.userPass.UserPass;

public class UserPassJDBCPostgreSQL implements UserPassDAO {
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
        return null;
    }
}
