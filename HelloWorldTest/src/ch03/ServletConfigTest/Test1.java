package ch03.ServletConfigTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Test1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 读取servlet 对象的配置信息，使用servletconfig 对象
        * */
        resp.setCharacterEncoding("gbk");
        resp.setContentType("text/html;charset=gbk");
        PrintWriter out=resp.getWriter();

        ServletConfig config=this.getServletConfig();
        String danwei=config.getInitParameter("danwei");
        String encoding=config.getInitParameter("bianma");

        out.println("<h1>单位名称："+danwei+"</h1>");
        out.println("<h1>单位编码："+encoding+"</h1>");

    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        super.doPost(req,resp);
    }
}
