package iuh.fit.se.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import iuh.fit.se.dao.DienthoaiDao;
import iuh.fit.se.dao.NhaCungCapDao;

import java.io.IOException;

@WebServlet("/ncc")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private final NhaCungCapDao nccDAO = new NhaCungCapDao();
    private final DienthoaiDao dtDAO = new DienthoaiDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String q = req.getParameter("q"); // từ khoá tìm kiếm NCC
            if (q == null || q.isBlank()) {
                req.setAttribute("nccList", nccDAO.findAll());
            } else {
                req.setAttribute("nccList", nccDAO.search(q));
            }

            String mancc = req.getParameter("mancc");
            if (mancc != null && mancc.matches("\\d+")) {
                req.setAttribute("dtList", dtDAO.findByNcc(Integer.parseInt(mancc)));
                req.setAttribute("selectedNcc", Integer.parseInt(mancc));
            }

            req.getRequestDispatcher("/WEB-INF/views/danh_sach_theo_ncc.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
