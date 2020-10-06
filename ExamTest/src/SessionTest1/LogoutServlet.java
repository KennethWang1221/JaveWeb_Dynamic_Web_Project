package SessionTest1;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text.html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        HttpSession session=req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect("/ExamTest/SessionTest5");

    }

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        this.doGet(req,resp);
    }
}
