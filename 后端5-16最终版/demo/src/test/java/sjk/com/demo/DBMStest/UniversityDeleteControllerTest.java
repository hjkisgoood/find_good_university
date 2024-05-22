package sjk.com.demo.DBMStest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class UniversityDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDeleteUniversity() throws Exception {
        Long universityId =33L; // 设置要删除的大学信息的ID

        // 执行 DELETE 请求以删除大学信息
        ResultActions result = mockMvc.perform(delete("/universities/{universityId}", universityId)
                .contentType(MediaType.APPLICATION_JSON));

        // 验证响应状态码
        result.andExpect(status().isOk());
    }
}
