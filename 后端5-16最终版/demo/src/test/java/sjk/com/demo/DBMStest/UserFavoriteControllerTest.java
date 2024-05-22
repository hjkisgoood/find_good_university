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
import sjk.com.demo.entity.Universities;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class UserFavoriteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetUserFavorites() throws Exception {
        // 发起GET请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/collections"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 获取响应体
        String responseBody = result.getResponse().getContentAsString();

        // 将JSON字符串转换为Universities对象列表
        List<Universities> favorites = objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, Universities.class));

        // 验证返回的收藏的大学列表不为空
        assertThat(favorites).isNotNull();

        // 进一步验证返回的收藏的大学列表内容
        for (Universities favorite : favorites) {
            System.out.println("University ID: " + favorite.getUniversityID());
            System.out.println("University Name: " + favorite.getName());
            // 输出其他属性值
        }
    }
}
