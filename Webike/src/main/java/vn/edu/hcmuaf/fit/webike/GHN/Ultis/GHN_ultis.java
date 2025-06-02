package vn.edu.hcmuaf.fit.webike.GHN.Ultis;

import org.json.JSONObject;
import vn.edu.hcmuaf.fit.webike.GHN.GHN_config.GHN_Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GHN_ultis {
    public static String callGetAPI(String endpoint, String request_method) {
        try {
            String urlStr = GHN_Config.BASE_URL.replace("/v2", "") + endpoint;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod(request_method);
            conn.setRequestProperty("Token", GHN_Config.TOKEN);
            conn.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Không thể gọi GHN API\"}";
        }
    }

    public static String callPostAPI(String endpoint, String jsonBody) {
        try {
            URL url = new URL(GHN_Config.BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Token", GHN_Config.TOKEN);
            conn.setRequestProperty("ShopId", GHN_Config.SHOP_ID);
            conn.setRequestProperty("Content-Type", "application/json");

            // Gửi JSON body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Đọc phản hồi
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
            br.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Không thể gọi POST API: " + endpoint + "\"}";
        }
    }

    public static String getProvince() {
        String method = "GET";
        return callGetAPI("/master-data/province", method);
    }

    public static String createOrder(String json) {
        String endpoint = "/shipping-order/create";
        return callPostAPI(endpoint, json);
    }

    public static String getOrderDetail(String json) {
        String endpoint = "/shipping-order/detail";
        return callPostAPI(endpoint, json);
    }

    public static String generateJsonOrder(int oid, String username, String phoneNum, String address) {
        List<String> ls_address = new ArrayList<>();
        String[] parts = address.split(",");
        for (String part : parts) {
            ls_address.add(part.trim());
        }
        String to_address = ls_address.get(0);
        String to_ward_name = ls_address.get(1);
        String to_district_name = ls_address.get(2);
        String to_province_name = ls_address.get(3);

        int service_type_id = 2;
        int payment_type_id = 2;
        String required_note = "CHOXEMHANGKHONGTHU";

        String json = """
                {
                    "payment_type_id": %d,
                    "note": "Đơn hàng Webike #%d",
                    "required_note": "%s",
                    "return_phone": "",
                    "return_address": "",
                    "return_district_id": null,
                    "return_ward_code": "",
                    "client_order_code": "",
                    "from_name": "",
                    "from_phone": "",
                    "from_address": "",
                    "from_ward_name": "",
                    "from_district_name": "",
                    "from_province_name": "",
                    "to_name": "%s",
                    "to_phone": "%s",
                    "to_address": "%s",
                    "to_ward_name": "%s",
                    "to_district_name": "%s",
                    "to_province_name": "%s",
                    "cod_amount": 0,
                    "content": "Webike Order",
                    "length": 20,
                    "width": 20,
                    "height": 20,
                    "weight": 1000,
                    "cod_failed_amount": 0,
                    "pick_station_id": null,
                    "deliver_station_id": null,
                    "insurance_value": 0,
                    "service_type_id": %d,
                    "coupon": null,
                    "pickup_time": null,
                    "pick_shift": [],
                    "items": [
                        {
                            "name": "Sản phẩm Webike",
                            "code": "WB-%d",
                            "quantity": 1,
                            "price": 0,
                            "length": 20,
                            "width": 20,
                            "height": 20,
                            "weight": 1000,
                            "category": {
                                "level1": "Khác"
                            }
                        }
                    ]
                }
                """.formatted(
                payment_type_id,
                oid,
                required_note,
                username,
                phoneNum,
                to_address,
                to_ward_name,
                to_district_name,
                to_province_name,
                service_type_id,
                oid
        );
        return json;
    }

    public static String generateJsonOrderCode(String order_code) {
        JSONObject json = new JSONObject();
        json.put("order_code", order_code);
        return json.toString();
    }
}
