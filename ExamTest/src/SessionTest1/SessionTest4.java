
package SessionTest1;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SessionTest4 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        /*resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        String usn=req.getParameter("username");
        String psd=req.getParameter("password");

        HttpSession session=req.getSession();

        if(("wangxiang").equals(usn)&&("123").equals(psd)){
            SessionUserVo user=new SessionUserVo();
            user.setName(usn);
            user.setPassword(psd);
            session.setAttribute("sessionuser",user);
            resp.sendRedirect("/ExamTest/SessionTest5");


        }else{
            out.println("用户名或者密码错误，登陆失败");
            resp.sendRedirect("/ExamTest/SessionLogin.jsp");

        }*/

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        String usn=req.getParameter("username");
        String psd=req.getParameter("password");

        HttpSession session=req.getSession();
        if(("wangxiang").equals(usn)&&("123").equals(psd)){
            SessionUserVo user=new SessionUserVo();
            user.setName(usn);
            user.setPassword(psd);

            session.setAttribute("sessionuser",user);

        }else{
            out.println("您登录未成功");
            resp.sendRedirect("/SessoinLogin.jsp");

        }




    }

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        this.doGet(req,resp);

    }
}













