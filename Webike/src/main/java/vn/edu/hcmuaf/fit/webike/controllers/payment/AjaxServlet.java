package vn.edu.hcmuaf.fit.webike.controllers.payment;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.models.PaymentResponse;
import vn.edu.hcmuaf.fit.webike.vnpayConfig.Config;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "AjaxServlet", value = "/vnpayment")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PaymentDAO dao = new PaymentDAO();
        // lay data tu form payment.jsp
        double deposit = Double.parseDouble(req.getParameter("deposit"));
        double remain = Double.parseDouble(req.getParameter("remain"));
        String appointment = req.getParameter("appointment");
        String address = req.getParameter("address");
//        String status = "Đã cọc";
        int accountID = Integer.parseInt(req.getParameter("accountID"));

        String branch = req.getParameter("branch"); // branch là chi nhánh =))
        StringTokenizer t = new StringTokenizer(branch, "-");
        int shopID = Integer.parseInt(t.nextToken());

        int oid = dao.creatOrderID();
        req.getSession().setAttribute("remain", remain);
        req.getSession().setAttribute("appointment", appointment);
        req.getSession().setAttribute("address", address);
        req.getSession().setAttribute("accountID", accountID);
        req.getSession().setAttribute("shopID", shopID);


//        double deposit = Double.parseDouble(req.getParameter("deposit"));
        long amount = (long) (deposit * 100);

        String bankCode = req.getParameter("bankCode");
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = Config.getIpAddress(req);
        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", Config.vnp_Version);
        vnp_Params.put("vnp_Command", Config.vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_BankCode", "NCB");
//        vnp_Params.put("vnp_TxnRef", vnp_TxnRef); // thay bằng id đơn hàng
        vnp_Params.put("vnp_TxnRef", String.valueOf(oid)); // thay bằng id đơn hàng
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + oid);
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_OrderType", Config.orderType);
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;

        PaymentResponse payment = new PaymentResponse();
        // TH thanh toan thanh cong
        payment.setStatus("Success");
        payment.setMessage("Payment Successful");
        payment.setUrl(paymentUrl);

        resp.sendRedirect(payment.getUrl());

    }
}