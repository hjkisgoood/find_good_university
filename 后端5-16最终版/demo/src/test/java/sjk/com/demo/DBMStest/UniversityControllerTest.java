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
import sjk.com.demo.entity.Universities;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class UniversityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testPublishUniversity() throws Exception {
        // Create a sample university object
        Universities university = new Universities();
        university.setName("Sample University2");
        university.setType("Public");
        university.setCampusArea(1000.0);
        university.setMinFee(5000.0);
        university.setMaxFee(10000.0);
        university.setProvince("Province");
        university.setCity("City");
        university.setAddress("Address");
        university.setClimate("Climate");
        university.setApplicationDeadline("2021.1.1");

        // Convert the university object to JSON
        String universityJson = objectMapper.writeValueAsString(university);

        // Perform the POST request to publish the university information
        ResultActions result = mockMvc.perform(post("/universities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(universityJson));

        // Verify the response status
        result.andExpect(status().isOk());
    }
}