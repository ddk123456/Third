package cn.edu.guet.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("第三个Web后端程序");
        String citykey=request.getParameter("citykey");//get：获取，parameter：参数
        System.out.println(citykey);

        String password=request.getParameter("password");
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
