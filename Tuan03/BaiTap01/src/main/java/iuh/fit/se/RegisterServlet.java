package iuh.fit.se;

import iuh.fit.se.entities.Student;
import jakarta.servlet.http.HttpServlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fb = request.getParameter("fb");
        String bio = request.getParameter("bio");

        // Tạo đối tượng Student
        Student student = new Student(firstName, lastName, username, email, password, fb, bio);

        // Truyền sang JSP
        request.setAttribute("student", student);

        // Forward sang result.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
