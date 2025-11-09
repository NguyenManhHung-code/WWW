package iuh.fit.se.baitap02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "D:/upload"; // thư mục lưu file

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        filePart.write(UPLOAD_DIR + File.separator + fileName);

        // chuyển sang servlet list
        resp.sendRedirect("list");
    }
}

