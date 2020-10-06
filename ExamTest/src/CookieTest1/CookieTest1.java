package CookieTest1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns="/CookieTest1")
public class CookieTest1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out =resp.getWriter();
        String currentTime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        String lastAccessTime=null;


        Cookie cookie=new Cookie("lastAccess",currentTime);
        resp.addCookie(cookie);


        Cookie[] cookies=req.getCookies();
        for(int i=0;cookies!=null&&i<cookies.length;i++){
            if("lastAccess".equals(cookies[i].getName())){
                lastAccessTime=cookies[i].getValue();
            }
            break;
        }


        if(lastAccessTime==null){
            resp.getWriter().print("您是首次访问本网站");
        }else{
            resp.getWriter().print("您上次访问本网站是"+lastAccessTime);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}


