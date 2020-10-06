package SessionTest1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns="/SessionTest1")
public class SessionTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        //在Session 中给session 保存数据
        HttpSession session =req.getSession();
        session.setMaxInactiveInterval(60);
        String msg="学校名称";

        session.setAttribute("msg",msg);
        out.println("会话对象数据已经OK");
        out.println("<a href=\"SessionTest2\">SessionTest2</a>");



    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        this.doGet(req,resp);

    }
}
