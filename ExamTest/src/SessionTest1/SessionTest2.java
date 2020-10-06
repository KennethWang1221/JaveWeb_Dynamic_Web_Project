package SessionTest1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


@WebServlet(urlPatterns="/SessionTest2")
public class SessionTest2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        //在SessionTest2程序中 从session中获取数据
        HttpSession session=req.getSession();
        String msg2=(String)session.getAttribute("msg");

        out.println("<h1>msg:"+msg2+"</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException ,IOException{
       this.doGet(req,resp);
    }
}
