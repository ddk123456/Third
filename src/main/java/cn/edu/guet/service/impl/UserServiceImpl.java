package cn.edu.guet.service.impl;

import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.dao.impl.UserDaoImpl;
import cn.edu.guet.service.IUserService;

public class UserServiceImpl implements IUserService {
    @Override
    public boolean login(String username, String password) {
        IUserDao userDao = new UserDaoImpl();
        boolean result = userDao.login(username, password);
        return result;
    }
}
