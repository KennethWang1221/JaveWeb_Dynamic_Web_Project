package SessionTest1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

@WebServlet(urlPatterns="/SessionTest3")
public class SessionTest3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
      resp.setCharacterEncoding("utf-8");
      resp.setContentType("text/html;charset=utf-8");
      PrintWriter out=resp.getWriter();

      HttpSession session=req.getSession();

      //输出ID,进行观察
        String ssid=session.getId();
        out.println("<h1>Test2页面中的session ssid:"+ssid+"</h1>");

        out.println("<h1>Test2页面中的 isNew:"+session.isNew()+"</h1>");


    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{


    }
}
