
package CookieTest1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns="/CookieTest2")
public class CookieTest2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException ,IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        Cookie ck1 = new Cookie("name", "wangxiang");
        Cookie ck2 = new Cookie("Address", "xian");

        resp.addCookie(ck1);
        resp.addCookie(ck2);

        ck1.setMaxAge(200);
        ck2.setMaxAge(200);

        Cookie[] cks = req.getCookies();

        if (cks == null) {
            out.println("第一次访问无数据");
        } else {
            for (int i = 0; i < cks.length && cks[i] != null; i++) {
                out.println("<h1>ckname:" + cks[i].getName() + "</h1>");
                out.println("<h1>ckvalue:" + cks[i].getValue() + "</h1>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException ,IOException{
        this.doGet(req,resp);

    }
}