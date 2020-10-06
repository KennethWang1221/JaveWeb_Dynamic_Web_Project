package ServletTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns="/RequestParamServlet")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        String name1=req.getParameter("usn");
        String pasd=req.getParameter("psd");
        out.println("姓名"+name1+"密码"+pasd);

        String[] hobbys=req.getParameterValues("hobby");
        if(hobbys!=null){
            for(int i=0;i<hobbys[i].length();i++){
                out.println("爱好："+hobbys[i]);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
