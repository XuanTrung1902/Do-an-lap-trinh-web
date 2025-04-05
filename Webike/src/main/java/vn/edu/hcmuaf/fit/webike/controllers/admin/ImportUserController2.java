//package vn.edu.hcmuaf.fit.webike.controllers.admin;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import java.io.IOException;
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import vn.edu.hcmuaf.fit.webike.dao.UserDao;
//import vn.edu.hcmuaf.fit.webike.models.User;
//import vn.edu.hcmuaf.fit.webike.services.UserSevice;
//
//import java.io.InputStream;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//@WebServlet(name = "ImportUserController2", value = "/importUser")
//@MultipartConfig
//public class ImportUserController2 extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Part filePart = request.getPart("userFile");
//        InputStream fileContent = filePart.getInputStream();
//
//        UserDao userDao = new UserDao();
//        try (Workbook workbook = new XSSFWorkbook(fileContent)) {
//            Sheet sheet = workbook.getSheetAt(0);
//            for (Row row : sheet) {
//                if (row.getRowNum() == 0) continue; // Bỏ qua dòng tiêu đề
//
//                try {
//                    String name = getCellValueAsString(row.getCell(0));
//                    String phoneNum = getCellValueAsString(row.getCell(1));
//                    String dobStr = getCellValueAsString(row.getCell(2));
//                    String sex = getCellValueAsString(row.getCell(3));
//                    String password = getCellValueAsString(row.getCell(4));
//                    String address = getCellValueAsString(row.getCell(5));
//                    String email = getCellValueAsString(row.getCell(6));
//                    String lockedStr = getCellValueAsString(row.getCell(7));
//                    String verifyStr = getCellValueAsString(row.getCell(8));
//                    String roleStr = getCellValueAsString(row.getCell(9));
//
//                    if (lockedStr.isEmpty() || verifyStr.isEmpty() || roleStr.isEmpty()) {
//                        System.out.println("Bỏ qua dòng " + row.getRowNum() + " vì thiếu locked/verify/role");
//                        continue;
//                    }
//
//                    int locked = Integer.parseInt(lockedStr);
//                    int verify = Integer.parseInt(verifyStr);
//                    int role = Integer.parseInt(roleStr);
//
//                    if (UserSevice.isPhoneNumExists(phoneNum)) continue;
//
//                    // Parse ngày sinh
//                    Date DOB = Date.valueOf(LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//
//                    User user = new User();
//                    user.setName(name);
//                    user.setPhoneNum(phoneNum);
//                    user.setDOB(DOB);
//                    user.setSex(sex);
//                    user.setPassword(UserSevice.hashPassword(password));
//                    user.setCreated(LocalDate.now().toString());
//                    user.setLocked(locked);
//                    user.setVerify(verify);
//                    user.setRole(role);
//                    user.setAddress(address);
//                    user.setEmail(email);
//
//                    userDao.addUserAdmin(user);
//                } catch (Exception rowErr) {
//                    System.out.println("Lỗi dòng " + row.getRowNum() + ": " + rowErr.getMessage());
//                    // Có thể log lại hoặc bỏ qua dòng lỗi
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("error", "Có lỗi xảy ra khi nhập dữ liệu từ file Excel.");
//            System.out.println(e.getMessage());
////            request.getRequestDispatcher("/importUser").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/userList");
//            return;
//        }
//
//        response.sendRedirect(request.getContextPath() + "/userList");
//    }
//    private String getCellValueAsString(Cell cell) {
//        if (cell == null) return "";
//        return switch (cell.getCellType()) {
//            case STRING -> cell.getStringCellValue().trim();
//            case NUMERIC -> {
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    // Nếu là ngày, format lại kiểu dd/MM/yyyy
//                    yield new SimpleDateFormat("dd/MM/yyyy").format(cell.getDateCellValue());
//                } else {
//                    // Trả về số, loại bỏ phần thập phân nếu là số nguyên
//                    double num = cell.getNumericCellValue();
//                    yield (num == Math.floor(num)) ? String.valueOf((long) num) : String.valueOf(num);
//                }
//            }
//            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
//            case FORMULA -> cell.getCellFormula();
//            default -> "";
//        };
//    }
//
//}