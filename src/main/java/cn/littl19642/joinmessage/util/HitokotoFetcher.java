package cn.littl19642.joinmessage.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HitokotoFetcher {

    public static String getHitokoto() {
        try {
            URL url = new URL("https://v1.hitokoto.cn/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
            return json.get("hitokoto").getAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return "获取一言失败";
        }
    }
}
