package sjk.com.demo.DBMStest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class portTest {
    public static void main(String[] args) {
        String host = "10.29.69.224";
        int port = 8080;
        String endpoint = "/login";
        String urlString = "http://" + host + ":" + port + endpoint;

        try {
            // 创建URL对象
            URL url = new URL(urlString);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置请求方法为POST
            connection.setRequestMethod("POST");
            // 设置请求内容类型为JSON
            connection.setRequestProperty("Content-Type", "application/json");
            // 开启输出流，向服务器发送数据
            connection.setDoOutput(true);

            // 准备要发送的JSON数据
            String jsonInputString = "{\"username\": \"1\", \"password\": \"1\"}";

            // 获取输出流并写入JSON数据
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // 获取响应码
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取响应内容
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("Response message: " + response.toString());
                }
            } else {
                // TODO: 处理登录失败的逻辑
                System.out.println("Login failed");
            }

            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
