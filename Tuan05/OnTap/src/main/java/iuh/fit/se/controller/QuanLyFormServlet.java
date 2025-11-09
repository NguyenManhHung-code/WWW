package iuh.fit.se.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import iuh.fit.se.dao.DienthoaiDao;

import java.io.IOException;

@WebServlet("/manage")
public class QuanLyFormServlet extends HttpServlet {
    private final DienthoaiDao dtDAO = new DienthoaiDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            String id = req.getParameter("madt");
            if (id != null && id.matches("\\d+")) {
                try {
                    dtDAO.delete(Integer.parseInt(id));
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }
        }
        resp.sendRedirect(req.getHeader("Referer") != null
                ? req.getHeader("Referer")
                : (req.getContextPath() + "/ncc"));
    }
}
