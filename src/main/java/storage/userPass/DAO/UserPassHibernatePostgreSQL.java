package storage.userPass.DAO;

import storage.userPass.UserPass;

public class UserPassHibernatePostgreSQL implements UserPassDAO {
    @Override
    public boolean addUserPass(UserPass userPass) {
        return false;
    }

    @Override
    public boolean changeUserPass(UserPass userPass) {
        return false;
    }

    @Override
    public String getPassByUserId(int id) {
        return null;
    }
}
