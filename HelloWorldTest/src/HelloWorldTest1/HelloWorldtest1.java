package HelloWorldTest1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldtest1 extends  HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("gbk");
        resp.setContentType("text/html;charset=gbk");
        PrintWriter out=resp.getWriter();

        out.println("HelloWorld");
        out.println("这是我的Idea_Project下的第一个HelloWorldTest项目下的HelloWorldtest1 class文件");


}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
