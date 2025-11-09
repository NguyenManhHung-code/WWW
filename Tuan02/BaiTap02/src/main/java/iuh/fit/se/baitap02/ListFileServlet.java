package iuh.fit.se.baitap02;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ListFileServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "D:/upload";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        File folder = new File(UPLOAD_DIR);
        File[] files = folder.listFiles();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<h2>Danh sách file đã upload:</h2>");
        out.println("<ul>");
        if (files != null) {
            for (File f : files) {
                out.println("<li>" + f.getName() + "</li>");
            }
        }
        out.println("</ul>");
        out.println("<a href='index.jsp'>Quay lại upload</a>");
    }
}