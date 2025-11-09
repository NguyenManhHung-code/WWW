package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Ex2_HTML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>Index Servlet 123</h1>");
        writer.println("<p><a href=\"http://localhost:8080/Tuan01_war_exploded/json\">Đi đến trang JSON</a></p>");
        writer.println("</body></html>");
    }
}
