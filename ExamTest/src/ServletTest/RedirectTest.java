package ServletTest;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/RedirectTest")
public class RedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("usn");
        String password=req.getParameter("psd");

        if(("wx").equals(username)&&("123".equals(password))){
            resp.sendRedirect("/ExamTest/welcome.jsp");
        }else{
            resp.sendRedirect("/ExamTest/login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
