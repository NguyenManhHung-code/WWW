package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerData", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>Register Data</h1>");
        writer.println("<h1>First Name: " + req.getParameter("firstName" ) +"</h1>");
        writer.println("<h1>Last Name: " + req.getParameter("lastName" ) +"</h1>");
        writer.println("<h1>Username: " + req.getParameter("username") +"</h1>");
        writer.println("<h1>email: " + req.getParameter("email") +"</h1>");
        writer.println("<h1>Facebook: " + req.getParameter("fb") +"</h1>");
        writer.println("<h1>Bio: " + req.getParameter("bio") +"</h1>");
        writer.println("</body></html>");
        writer.close();
    }
}
