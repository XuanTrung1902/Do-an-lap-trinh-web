package vn.edu.hcmuaf.fit.webike.controllers.users;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "QRCodeServlet", value = "/qr-code")
public class QRCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String otpUrl = req.getParameter("data");
        if (otpUrl == null || otpUrl.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu dữ liệu QR");
            return;
        }
        try {
            int width = 200;
            int height = 200;
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(otpUrl, BarcodeFormat.QR_CODE, width, height);

            resp.setContentType("image/png");
            ServletOutputStream outputStream = resp.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            outputStream.flush();
        } catch (WriterException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi tạo mã QR");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}