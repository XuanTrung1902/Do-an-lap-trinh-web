package vn.edu.hcmuaf.fit.webike.controllers.admin;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Pattern;

@WebServlet(name = "ImportUserController", value = "/importUser")
@MultipartConfig
public class ImportUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errorMessages = new ArrayList<>();
        List<User> users = new ArrayList<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            Part filePart = request.getPart("userFile");

            if (filePart != null && filePart.getSize() > 0) {
                try (InputStream fileStream = filePart.getInputStream();
                     Workbook workbook = new XSSFWorkbook(fileStream)) {

                    Sheet sheet = workbook.getSheetAt(0);

                    for (Row row : sheet) {
                        if (row.getRowNum() == 0) continue;

                        try {
                            User user = new User();

                            user.setName(getCellValue(row.getCell(0)).trim());
                            user.setAddress(getCellValue(row.getCell(5)).trim());
                            user.setEmail(getCellValue(row.getCell(6)).trim());
                            user.setPassword(UserSevice.hashPassword(getCellValue(row.getCell(4))));

                            // Ngày sinh
                            Cell dobCell = row.getCell(2);
                            if (dobCell != null) {
                                if (dobCell.getCellType() == CellType.NUMERIC) {
                                    user.setDOB(new java.sql.Date(dobCell.getDateCellValue().getTime()));
                                } else {
                                    String dobStr = dobCell.getStringCellValue().trim();
                                    try {
                                        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                                        java.util.Date parsedDate = inputFormat.parse(dobStr);
                                        user.setDOB(new java.sql.Date(parsedDate.getTime()));
                                    } catch (Exception e) {
                                        user.setDOB(null);
                                    }
                                }
                            }

                            // SĐT
                            Cell phoneCell = row.getCell(1);
                            String phoneNumber = (phoneCell != null && phoneCell.getCellType() == CellType.NUMERIC)
                                    ? String.format("%.0f", phoneCell.getNumericCellValue())
                                    : getCellValue(phoneCell);
                            user.setPhoneNum(phoneNumber);

                            // Giới tính
                            String gender = getCellValue(row.getCell(3)).trim();
                            user.setSex(gender.equalsIgnoreCase("Nam") ? "Male" : "Female");

                            // Các trường số
                            user.setLocked((int) row.getCell(7).getNumericCellValue());
                            user.setVerify((int) row.getCell(8).getNumericCellValue());
                            user.setRole((int) row.getCell(9).getNumericCellValue());

                            users.add(user);
                        } catch (Exception e) {
                            errorMessages.add("Lỗi tại dòng " + (row.getRowNum() + 1) + ": " + e.getMessage());
                        }
                    }

                    if (errorMessages.isEmpty()) {
                        UserDao userDAO = new UserDao();
                        userDAO.insertUsers(users); // Giả sử hàm này không trả lại danh sách có ID

                        // Sau khi insert, lấy lại danh sách có ID để trả về
                        List<User> insertedUsers = userDAO.getLatestInsertedUsers(users.size()); // Bạn phải có hàm này

                        // Trả về JSON
                        String json = buildSuccessJson(insertedUsers, request.getContextPath(), "Nhập dữ liệu thành công!");
                        response.getWriter().write(json);
                        return;
                    }
                }
            } else {
                errorMessages.add("Không có file được chọn.");
            }
        } catch (Exception e) {
            errorMessages.add("Lỗi khi xử lý file: " + e.getMessage());
        }

        // Trả về lỗi
        String jsonError = "{\"success\": false, \"message\": \"" + String.join("<br>", errorMessages).replace("\"", "\\\"") + "\"}";
        response.getWriter().write(jsonError);
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }
    private String buildSuccessJson(List<User> users, String contextPath, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"success\": true,");
        sb.append("\"message\": \"" + message + "\",");
        sb.append("\"contextPath\": \"" + contextPath + "\",");
        sb.append("\"users\": [");

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            sb.append("{")
                    .append("\"id\": ").append(user.getId()).append(",")
                    .append("\"name\": \"").append(user.getName()).append("\",")
                    .append("\"DOB\": \"").append(user.getDOB()).append("\",")
                    .append("\"sex\": \"").append(user.getSex()).append("\",")
                    .append("\"address\": \"").append(user.getAddress()).append("\",")
                    .append("\"phoneNum\": \"").append(user.getPhoneNum()).append("\",")
                    .append("\"role\": ").append(user.getRole()).append(",")
                    .append("\"locked\": ").append(user.getLocked()).append(",")
                    .append("\"image\": \"").append(user.getImage() != null ? user.getImage() : "").append("\"")
                    .append("}");

            if (i < users.size() - 1) sb.append(",");
        }

        sb.append("]}");
        return sb.toString();
    }


}