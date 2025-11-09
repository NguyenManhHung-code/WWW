package iuh.fit.se;

import iuh.fit.se.entities.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String dob = day + "/" + month + "/" + year;
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");

        String[] hobbiesArray = request.getParameterValues("hobbies");
        String hobbyOther = request.getParameter("hobbyOther");
        StringBuilder hobbies = new StringBuilder();
        if (hobbiesArray != null) {
            for (String h : hobbiesArray) {
                hobbies.append(h).append(", ");
            }
        }
        if (hobbyOther != null && !hobbyOther.trim().isEmpty()) {
            hobbies.append(hobbyOther);
        }

        // Lấy thông tin học vấn
        String qualification = "";
        qualification += "X: " + request.getParameter("boardX") + " - " + request.getParameter("percentX") + "% - " + request.getParameter("yearX") + "<br/>";
        qualification += "XII: " + request.getParameter("boardXII") + " - " + request.getParameter("percentXII") + "% - " + request.getParameter("yearXII") + "<br/>";
        qualification += "Grad: " + request.getParameter("boardGrad") + " - " + request.getParameter("percentGrad") + "% - " + request.getParameter("yearGrad") + "<br/>";
        qualification += "Masters: " + request.getParameter("boardMasters") + " - " + request.getParameter("percentMasters") + "% - " + request.getParameter("yearMasters");

        String course = request.getParameter("course");

        // Tạo student object
        Student sv = new Student(firstName, lastName, dob, email, mobile, gender, address,
                city, pincode, state, country, hobbies.toString(), qualification, course);

        request.setAttribute("student", sv);

        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
