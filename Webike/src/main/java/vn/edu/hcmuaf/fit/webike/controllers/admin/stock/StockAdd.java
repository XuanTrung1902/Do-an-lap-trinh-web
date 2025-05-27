package vn.edu.hcmuaf.fit.webike.controllers.admin.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.edu.hcmuaf.fit.webike.dao.StockDAO;
import vn.edu.hcmuaf.fit.webike.models.Supplier;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StockAdd", value = "/stock-add")
@MultipartConfig
public class StockAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StockDAO dao = new StockDAO();
        List<Supplier> suppliers = dao.getAllSuppliers();

        request.setAttribute("suppliers", suppliers);
        request.getRequestDispatcher("Admin/stockAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int supplierID = Integer.parseInt(request.getParameter("supplierID"));
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        String receiptDate = request.getParameter("receiptDate");
        String note = request.getParameter("note");
        Part filePart = request.getPart("filePart");

        StockDAO dao = new StockDAO();

        if (filePart != null) {
            int stockID = dao.insertStockIn(supplierID, employeeID, receiptDate, note);
            try (InputStream inputStream = filePart.getInputStream(); Workbook workbook = new XSSFWorkbook(inputStream)) {

                LinkedHashMap<Integer, Integer> stockBatchMap = new LinkedHashMap<>(); // map luu <id batch, id batch trong excel>
                LinkedHashMap<Integer, Integer> stockItemMap = new LinkedHashMap<>(); // map luu <id stock item, id batch trong excel>

                // xly stock batch
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue; // dong 0 chi hien ten
                    String s0 = getCellValue(row.getCell(0));
                    String s1 = getCellValue(row.getCell(1));
                    String s2 = getCellValue(row.getCell(2));
                    String s3 = getCellValue(row.getCell(3));
                    String s4 = getCellValue(row.getCell(4));
                    String s5 = getCellValue(row.getCell(5));

                    if (s0.isEmpty() || s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()) {
                        continue; // bo qua dong nay neu cell rong
                    }

                    int temp_batchID = Integer.parseInt(s0);
                    int pid = Integer.parseInt(s1);
                    int quantity = Integer.parseInt(s2);
                    int unitPrice = Integer.parseInt(s3);
                    int totalPrice = Integer.parseInt(s4);
                    int importID = Integer.parseInt(s5);

                    String batch = "BATCH/" + receiptDate + "/" + "import" + importID + "/" + pid;
                    int batchID = dao.insertStockBatch(stockID, pid, quantity, unitPrice, totalPrice, batch, importID);
                    stockBatchMap.put(batchID, temp_batchID);

                    // xly stock item
                    Sheet sheet1 = workbook.getSheetAt(1);
                    for (Row row1 : sheet1) {
                        if (row1.getRowNum() == 0) {
                            continue;
                        }
                        Cell cell1_0 = row1.getCell(0);
                        Cell cell1_1 = row1.getCell(1);
                        Cell cell1_2 = row1.getCell(2);
                        Cell cell1_3 = row1.getCell(3);
                        Cell cell1_4 = row1.getCell(4);
                        int temp_batchID1 = Integer.parseInt(getCellValue(cell1_0));
                        int cid = Integer.parseInt(getCellValue(cell1_1));
                        int pid1 = Integer.parseInt(getCellValue(cell1_2));
                        int quantity1 = Integer.parseInt(getCellValue(cell1_3));
                        String status = getCellValue(cell1_4);

                        if (temp_batchID == temp_batchID1) {
                            for (int i = 0; i < quantity1; i++) {
                                int itemID = dao.insertStockItem(cid, pid1, status);
                                stockItemMap.put(itemID, temp_batchID1);
                            }
                        } else {
                            continue;
                        }
                    }
                }

                // update batchID trong StockItem
                for (Map.Entry<Integer, Integer> e1 : stockBatchMap.entrySet()) {
                    for (Map.Entry<Integer, Integer> e2 : stockItemMap.entrySet()) {
                        if (e1.getValue() == e2.getValue()) {
                            dao.updateBatchID(e2.getKey(), e1.getKey());
                        }
                    }
                }
            }
        }
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