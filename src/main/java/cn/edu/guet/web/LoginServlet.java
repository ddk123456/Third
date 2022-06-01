package cn.edu.guet.web;


import cn.edu.guet.common.Result;
import cn.edu.guet.service.IUserService;
import cn.edu.guet.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        IUserService userService=new UserServiceImpl();
        boolean result=userService.login(username,password);
        if(result){
            // 跳转页面：main.html
            // 跳转页面之前：把username发送给网页
            // request.getRequestDispatcher("main.html").forward(request,response);// 请求转发

            response.setContentType("application/json;charset=UTF-8");

            Result res=new Result("true",username);
            Gson gson=new Gson();
            String str=gson.toJson(res);

            System.out.println(str);

            PrintWriter out=response.getWriter();
            out.print(str);
            out.flush();
            out.close();

        }else{
            // 跳转页面：login.html
            response.sendRedirect("login.html");// 重定向
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
