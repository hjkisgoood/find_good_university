import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UniversityTest {
    public static void main(String[] args) {
        String host = "10.29.69.224";
        int port = 8080;
        String endpoint = "/users/universities";
        String urlString = "http://" + host + ":" + port + endpoint;

        try {
            // 创建URL对象
            URL url = new URL(urlString);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置请求方法为GET
            connection.setRequestMethod("GET");
            // 设置请求内容类型为JSON
            connection.setRequestProperty("Content-Type", "application/json");

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
                // TODO: 处理请求失败的逻辑
                System.out.println("Request failed");
            }

            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
