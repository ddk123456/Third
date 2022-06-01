package cn.edu.guet.web;

import okhttp3.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class WeatherServlet extends HttpServlet {
    /*
    request和response对象是tomcat创建的
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        对天气API请求，然后拿到JSON数据
         */
        String citykey=request.getParameter("citykey");

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request okRequest = new Request.Builder()
                .url("http://wthrcdn.etouch.cn/weather_mini?citykey="+citykey)
                .build();
        Response okResponse = client.newCall(okRequest).execute();// 发送请求，拿到响应

        /*
        响应数据
         */
        String weatherData=okResponse.body().string();

//        后台要给浏览器响应数据

        response.setContentType("application/json;charset=UTF-8");

        PrintWriter out=response.getWriter();
        out.print(weatherData);// print：打印，打印到浏览器（输出到浏览器）
        out.flush();
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
