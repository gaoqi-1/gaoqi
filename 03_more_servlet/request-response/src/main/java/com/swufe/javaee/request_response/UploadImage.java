package com.swufe.javaee.request_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/uploadImage")
@MultipartConfig
        public class UploadImage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getPart("Upload").write("C:\\Users\\Qi\\Desktop.png");
        response.sendRedirect("Success.html");

    }

}
