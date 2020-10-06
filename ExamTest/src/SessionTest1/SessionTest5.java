
package SessionTest1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


//@WebServlet(urlPatterns="/SessionTest5")
public class SessionTest5 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        /*HttpSession session=req.getSession();
        SessionUserVo user= (SessionUserVo) session.getAttribute("sessionuser");*/
        HttpSession session = req.getSession();
        SessionUserVo user = new SessionUserVo();
        user = (SessionUserVo) session.getAttribute("sessionuser");

        if (user == null) {
            out.println("您还没有登陆，请<a href='/ExamTest/SessionLogin.jsp'>登录</a>");
        } else {
            out.println("欢迎您！" + user.getName());
            out.println("<a href='/ExamTest/LogoutServlet'>退出</a>");

            Cookie ck = new Cookie("JSESSIONID", session.getId());
            ck.setMaxAge(60 * 30);
            ck.setPath("/ExamTest");
            resp.addCookie(ck);


        }
    }



    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        this.doGet(req,resp);

    }
}


