package cn.edu.guet.dao;

import cn.edu.guet.bean.Permission;

import java.util.List;

public interface IUserDao {

    boolean login(String username,String password);
}
