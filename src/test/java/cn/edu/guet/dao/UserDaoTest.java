package cn.edu.guet.dao;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.dao.impl.UserDaoImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testLogin() {
        /*
        在这里调用UserDaoImpl的login方法
         */
        IUserDao userDao = new UserDaoImpl();// 创建对象
        userDao.login("guet", "guet12345");
    }
}
