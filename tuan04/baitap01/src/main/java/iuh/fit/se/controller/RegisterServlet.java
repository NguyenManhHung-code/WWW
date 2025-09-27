package iuh.fit.se.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import iuh.fit.se.dao.daoImpl.UserDAOImpl;
import iuh.fit.se.dao.UserDAO;
import iuh.fit.se.entity.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String first = req.getParameter("firstName");
        String last = req.getParameter("lastName");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String gender = req.getParameter("gender");
        String birthdayStr = req.getParameter("birthday");
        LocalDate birthday = LocalDate.parse(birthdayStr);


        User u = new User(first, last, email, pass, birthday,gender);
        UserDAO dao = new UserDAOImpl();
        dao.addUser(u);

        req.setAttribute("users", dao.getAllUsers());
        req.getRequestDispatcher("list.jsp").forward(req, res);
    }
}
