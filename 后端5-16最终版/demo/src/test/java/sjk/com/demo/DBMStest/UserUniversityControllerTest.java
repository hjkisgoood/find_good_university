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
public class UserUniversityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetFilteredUniversitiesWithEmptyInput() throws Exception {
        // 发起GET请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/universities"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 获取响应体
        String responseBody = result.getResponse().getContentAsString();

        // 将JSON字符串转换为Universities对象列表
        List<Universities> universities = objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, Universities.class));

        // 验证返回的大学信息列表不为空
        assertThat(universities).isNotNull();

        // 进一步验证返回的大学信息列表内容
        for (Universities university : universities) {
            System.out.println("University ID: " + university.getUniversityID());
            System.out.println("University Name: " + university.getName());
            // 输出其他属性值
        }
    }
}
