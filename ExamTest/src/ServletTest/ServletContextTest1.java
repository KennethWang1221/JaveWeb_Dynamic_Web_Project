package ServletTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletContextTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out =resp.getWriter();
        ServletContext context=this.getServletContext();
        //String name=context.getInitParameter("name");
        String value=context.getInitParameter("学校");
        out.println(value);

        String msg=(String)context.getAttribute("address");
        out.println("共享的文件数据是："+msg+"!!!");



        ServletConfig config=this.getServletConfig();
        String param=config.getInitParameter("encoding");
        out.println("encoding:"+param);*/

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out =resp.getWriter();

        ServletConfig config=this.getServletConfig();
        String value=config.getInitParameter("encoding");
        out.println("value"+value);

        ServletContext context=this.getServletContext();
        String contextValue=(String)context.getInitParameter("学校");
        out.println("value"+contextValue);

        String msg=(String)context.getAttribute("msg");
        out.println(msg);





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
