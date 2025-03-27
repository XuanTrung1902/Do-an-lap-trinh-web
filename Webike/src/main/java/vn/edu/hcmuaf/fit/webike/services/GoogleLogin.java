package vn.edu.hcmuaf.fit.webike.services;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import org.apache.hc.client5.http.fluent.Request;
//import org.apache.hc.client5.http.fluent.Form;
//import org.apache.hc.client5.http.ClientProtocolException;
//import java.io.IOException;
//import vn.edu.hcmuaf.fit.webike.models.GoogleAccount;
//import vn.edu.hcmuaf.fit.webike.utils.Iconstant;
//
//public class GoogleLogin {
//    public GoogleAccount getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
//        String link = Iconstant.GOOGLE_LINK_GET_USER_INFO + accessToken;
//        String response = Request.get(link).execute().returnContent().asString();
//        GoogleAccount googlePojo = new Gson().fromJson(response, GoogleAccount.class);
//        return googlePojo;
//    }
//
//    public String getToken(String code) throws ClientProtocolException, IOException {
//        String response = Request.post(Iconstant.GOOGLE_LINK_GET_TOKEN)
//                .bodyForm(
//                        Form.form()
//                                .add("client_id", Iconstant.GOOGLE_CLIENT_ID)
//                                .add("client_secret", Iconstant.GOOGLE_CLIENT_SECRET)
//                                .add("redirect_uri", Iconstant.GOOGLE_REDIRECT_URI)
//                                .add("code", code)
//                                .add("grant_type", Iconstant.GOOGLE_GRANT_TYPE)
//                                .build()
//                )
//                .execute().returnContent().asString();
//        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
//        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
//        return accessToken;
//    }
//
//
//}
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.ClientProtocolException;
import java.io.IOException;
import vn.edu.hcmuaf.fit.webike.models.GoogleAccount;
import vn.edu.hcmuaf.fit.webike.utils.Iconstant;

public class GoogleLogin {
    public GoogleAccount getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Iconstant.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.get(link).execute().returnContent().asString();
        GoogleAccount googlePojo = new Gson().fromJson(response, GoogleAccount.class);
        return googlePojo;
    }

//    public String getToken(String code) throws ClientProtocolException, IOException {
//        try {
//            String response = Request.post(Iconstant.GOOGLE_LINK_GET_TOKEN)
//                    .bodyForm(
//                            Form.form()
//                                    .add("client_id", Iconstant.GOOGLE_CLIENT_ID)
//                                    .add("client_secret", Iconstant.GOOGLE_CLIENT_SECRET)
//                                    .add("redirect_uri", Iconstant.GOOGLE_REDIRECT_URI)
//                                    .add("code", code)
//                                    .add("grant_type", Iconstant.GOOGLE_GRANT_TYPE)
//                                    .build()
//                    )
//                    .execute().returnContent().asString();
//            JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
//            String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
//            return accessToken;
//        } catch (HttpResponseException e) {
//            System.err.println("HTTP Response Error: " + e.getStatusCode() + " - " + e.getReasonPhrase());
//            throw e;
//        }
//    }
public String getToken(String code) throws ClientProtocolException, IOException {
    try {
        String response = Request.post(Iconstant.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(
                        Form.form()
                                .add("client_id", Iconstant.GOOGLE_CLIENT_ID)
                                .add("client_secret", Iconstant.GOOGLE_CLIENT_SECRET)
                                .add("redirect_uri", Iconstant.GOOGLE_REDIRECT_URI)
                                .add("code", code)
                                .add("grant_type", Iconstant.GOOGLE_GRANT_TYPE)
                                .build()
                )
                .execute().returnContent().asString();

        System.out.println("🔍 Phản hồi từ Google khi lấy token: " + response); // Debug

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        if (!jobj.has("access_token")) {
            throw new RuntimeException("❌ Google không trả về access_token: " + response);
        }

        return jobj.get("access_token").getAsString();
    } catch (HttpResponseException e) {
        System.err.println("❌ Lỗi HTTP Response: " + e.getStatusCode() + " - " + e.getReasonPhrase());
        throw e;
    }
}

}
