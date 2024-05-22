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
import sjk.com.demo.entity.Dormitories;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class UserDormitoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDormitoriesByUniversityId() throws Exception {
        // 发送 GET 请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/universities/1/dormitories"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 获取响应体
        String content = result.getResponse().getContentAsString();

        // 将响应体转换为 Dormitories 对象
        Dormitories dormitories = new ObjectMapper().readValue(content, Dormitories.class);

        // 验证返回的宿舍信息不为空
        assertThat(dormitories).isNotNull();

        // 可以进一步验证返回的宿舍信息的具体内容

        System.out.println("Dormitory ID: " + dormitories.getDormitoryId());
        System.out.println("University ID: " + dormitories.getUniversityId());
        System.out.println("Has Private Bathroom: " + dormitories.isHasPrivateBathroom());
        System.out.println("Has Air Conditioning: " + dormitories.isHasAirConditioning());
        System.out.println("Has Bunk Bed Desk: " + dormitories.isHasBunkBedDesk());
        System.out.println("Roommate Count: " + dormitories.getRoommateCount());
    }
}
