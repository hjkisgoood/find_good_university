package sjk.com.demo.DBMStest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sjk.com.demo.entity.Canteens;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class UserCanteenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCanteensByUniversityId() throws Exception {
        // 发送 GET 请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/universities/1/canteens"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 获取响应体
        String content = result.getResponse().getContentAsString();

        // 将响应体转换为 Canteens 对象
        Canteens canteens = new ObjectMapper().readValue(content, Canteens.class);

        // 验证返回的食堂信息不为空
        assertThat(canteens).isNotNull();

        // 可以进一步验证返回的食堂信息的具体内容

        System.out.println("Canteen ID: " + canteens.getCanteenId());
        System.out.println("University ID: " + canteens.getUniversityId());
        System.out.println("Average Meal Price: " + canteens.getAverageMealPrice());
        System.out.println("Has Sichuan Cuisine: " + canteens.isHasSichuan());
        System.out.println("Has Shandong Cuisine: " + canteens.isHasShandong());
        System.out.println("Has Guangdong Cuisine: " + canteens.isHasGuangdong());
            // 进一步输出其他属性

    }
}
