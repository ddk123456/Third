package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.util.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public boolean login(String username, String password) {
        Connection conn = null;
        String user = "root";// mysql的用户名
        String pwd = "Li123456";
        String url = "jdbc:mysql://localhost:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT password,salt FROM sys_user WHERE name=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);// 给占位符赋值
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 如果满足这个条件，说明什么？说明：用户名是正确的
                String encPass = rs.getString("password");
                String salt = rs.getString("salt");

                PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
                boolean result = encoderMd5.matches(encPass, password);
                if (result) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
