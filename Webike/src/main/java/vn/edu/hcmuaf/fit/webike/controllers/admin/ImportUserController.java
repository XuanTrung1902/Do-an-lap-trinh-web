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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errorMessages = new ArrayList<>();

        try {
            Part filePart = request.getPart("userFile");

            if (filePart != null && filePart.getSize() > 0) {
                try (InputStream fileStream = filePart.getInputStream();
                     Workbook workbook = new XSSFWorkbook(fileStream)) {

                    Sheet sheet = workbook.getSheetAt(0);
                    List<User> users = new ArrayList<>();

                    for (Row row : sheet) {
                        if (row.getRowNum() == 0) continue;

                        try {
                            User user = new User();

                            user.setName(getCellValue(row.getCell(0)).trim());
                            user.setAddress(getCellValue(row.getCell(5)).trim());
                            user.setEmail(getCellValue(row.getCell(6)).trim());
                            user.setPassword(UserSevice.hashPassword( getCellValue(row.getCell(4))));

                            // Xử lý ngày sinh
                            Cell dobCell = row.getCell(2);
                            if (dobCell != null) {
                                try {
                                    if (dobCell.getCellType() == CellType.NUMERIC) {
                                        // Nếu là số, Excel lưu ngày tháng theo dạng số serial
                                        user.setDOB(new java.sql.Date(dobCell.getDateCellValue().getTime()));
                                    } else if (dobCell.getCellType() == CellType.STRING) {
                                        // Nếu là chuỗi, kiểm tra và chuyển đổi
                                        String dobStr = dobCell.getStringCellValue().trim();
                                        if (!dobStr.isEmpty()) {
                                            try {
                                                SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                                                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd"); // Chuyển sang định dạng Java yêu cầu
                                                java.util.Date parsedDate = inputFormat.parse(dobStr);
                                                String formattedDate = outputFormat.format(parsedDate);
                                                user.setDOB(java.sql.Date.valueOf(formattedDate)); // Chuyển thành SQL Date
                                            } catch (Exception e) {
                                                System.out.println("Lỗi khi chuyển đổi DOB: " + e.getMessage());
                                                user.setDOB(null);
                                            }
                                        }
                                    } else {
                                        user.setDOB(null);
                                    }
                                } catch (Exception e) {
                                    System.out.println("Lỗi khi xử lý ngày sinh: " + e.getMessage());
                                    user.setDOB(null);
                                }
                            }

                            // Xử lý số điện thoại
                            Cell phoneCell = row.getCell(1);
                            String phoneNumber = "";
                            if (phoneCell != null) {
                                if (phoneCell.getCellType() == CellType.NUMERIC) {
                                    phoneNumber = String.format("%.0f", phoneCell.getNumericCellValue());
                                } else {
                                    phoneNumber = getCellValue(phoneCell);
                                }
                            }
                            user.setPhoneNum(phoneNumber);

                            // Xử lý giới tính
                            Cell genderCell = row.getCell(3);
                            String gender = getCellValue(genderCell).trim();
                            user.setSex(gender.equalsIgnoreCase("Nam") ? "Male" : "Female");

                            // Xử lý các cột số nguyên
                            user.setLocked((int) row.getCell(7).getNumericCellValue());
                            user.setVerify((int) row.getCell(8).getNumericCellValue());
                            user.setRole((int) row.getCell(9).getNumericCellValue());

                            users.add(user);

                        } catch (Exception e) {
                            errorMessages.add("Lỗi tại dòng " + row.getRowNum() + ": " + e.getMessage());
                        }
                    }

                    // Lưu danh sách user vào DB
                    UserDao userDAO = new UserDao();
                    try {
                        userDAO.insertUsers(users);
                        request.setAttribute("message", "Nhập dữ liệu thành công!");
                    } catch (Exception e) {
                        errorMessages.add("Lỗi khi lưu vào DB: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            errorMessages.add("Lỗi khi xử lý file: " + e.getMessage());
        }

        // Gửi lỗi về giao diện nếu có
        if (!errorMessages.isEmpty()) {
            request.setAttribute("error", String.join("<br>", errorMessages));
        }

        response.sendRedirect(request.getContextPath() + "/userList");

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


}