package iuh.fit.se.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import iuh.fit.se.dao.DienthoaiDao;
import iuh.fit.se.dao.NhaCungCapDao;
import iuh.fit.se.entity.DienThoai;
import iuh.fit.se.entity.NhaCungCap;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

@WebServlet("/phone/new")
@MultipartConfig
public class DienThoaiFormServlet extends HttpServlet {
    private final NhaCungCapDao nccDAO = new NhaCungCapDao();
    private final DienthoaiDao dtDAO = new DienthoaiDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("nccList", nccDAO.findAll());
        req.getRequestDispatcher("/WEB-INF/views/form_dienthoai.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ten = req.getParameter("tendt");
        String namsx = req.getParameter("namsx");
        String cau = req.getParameter("cauhinh");
        int mancc = Integer.parseInt(req.getParameter("mancc"));

        Part filePart = req.getPart("hinhanh");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            String ct = filePart.getContentType();
            if (!(ct.equals("image/png") || ct.equals("image/jpeg"))) {
                req.setAttribute("error", "Ảnh chỉ PNG/JPG");
                doGet(req, resp);
                return;
            }
            String ext = ct.equals("image/png") ? ".png" : ".jpg";
            fileName = UUID.randomUUID() + ext;
            String uploadPath = getServletContext().getRealPath("/uploads");
            Files.createDirectories(new File(uploadPath).toPath());
            try (InputStream in = filePart.getInputStream();
                 OutputStream out = new FileOutputStream(uploadPath + "/" + fileName)) {
                in.transferTo(out);
            }
        }

        DienThoai dt = new DienThoai();
        dt.setTendt(ten);
        dt.setNamsanxuat(namsx);
        dt.setCauhinh(cau);
        dt.setHinhanh(fileName);

        NhaCungCap ncc = new DienthoaiDao().findNcc(mancc);
        dt.setNcc(ncc);

        dtDAO.insert(dt);
        resp.sendRedirect(req.getContextPath() + "/ncc?mancc=" + mancc);
    }
}
