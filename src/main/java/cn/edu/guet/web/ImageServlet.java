package cn.edu.guet.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("准备响应一个尧山的照片");
        response.setContentType("image/jpeg");


        /*
        使用IO流读取DSC_2554.JPG图片
         */
        try {
            InputStream in=Class.forName("cn.edu.guet.web.ImageServlet")
                    .getResourceAsStream("/DSC_2554.JPG");

            response.setHeader("Content-Length",String.valueOf(in.available()));

            ServletOutputStream out=response.getOutputStream();
            byte buff[]=new byte[1024*8];
            int a=0;
            while((a=in.read(buff))!=-1){
                out.write(buff,0,a);
            }
            out.flush();
            out.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
