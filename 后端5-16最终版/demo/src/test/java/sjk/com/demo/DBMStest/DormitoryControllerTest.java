package sjk.com.demo.DBMStest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import sjk.com.demo.entity.Dormitories;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DormitoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testPublishDormitory() throws Exception {
        // Create a sample dormitory object
        Dormitories dormitory = new Dormitories();
        dormitory.setUniversityId(4L);
        dormitory.setHasPrivateBathroom(true);
        dormitory.setHasAirConditioning(true);
        dormitory.setHasBunkBedDesk(false);
        dormitory.setRoommateCount(2);

        // Convert the dormitory object to JSON
        String dormitoryJson = objectMapper.writeValueAsString(dormitory);

        // Perform the POST request to publish the dormitory information
        ResultActions result = mockMvc.perform(post("/dormitories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dormitoryJson));

        // Verify the response status
        result.andExpect(status().isOk());
    }
}
