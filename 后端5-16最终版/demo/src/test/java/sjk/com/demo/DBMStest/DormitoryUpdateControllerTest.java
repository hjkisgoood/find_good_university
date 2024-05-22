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
public class DormitoryUpdateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testUpdateDormitory() throws Exception {
        // Create a sample dormitory object with updated information
        Dormitories dormitory = new Dormitories();
        dormitory.setDormitoryId(2L); // Set the dormitory ID of the dormitory to be updated
        dormitory.setHasPrivateBathroom(true);
        dormitory.setHasAirConditioning(true);
        dormitory.setHasBunkBedDesk(true);
        dormitory.setRoommateCount(3);

        // Convert the dormitory object to JSON
        String dormitoryJson = objectMapper.writeValueAsString(dormitory);

        // Perform the POST request to update the dormitory information
        ResultActions result = mockMvc.perform(post("/updateDormitory")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dormitoryJson));

        // Verify the response status
        result.andExpect(status().isOk());
    }
}

