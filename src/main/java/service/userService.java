package service;

import dao.userDao;
import model.User;

import java.sql.SQLException;

import static dao.userDao.isFound;

public class userService {
    public static Integer saveUser(User user) throws SQLException, ClassNotFoundException {
        if(isFound(user.getEmail())){
            return 0;
        }else {
            return userDao.saveUser(user);
        }
    }

}
