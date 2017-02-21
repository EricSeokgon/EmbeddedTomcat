import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project: EmbeddedTomcat
 * FileName: HelloWorldServlet
 * Date: 2017-02-21
 * Time: 오후 1:53
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello World!</h1>");
    }
}
