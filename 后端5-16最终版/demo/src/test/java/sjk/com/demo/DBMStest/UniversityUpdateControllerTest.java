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
public class UniversityUpdateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testUpdateUniversity() throws Exception {
        // Create a sample university object with updated information
        Universities university = new Universities();
        university.setUniversityID(1L); // Set the university ID of the university to be updated
        university.setName("Updated University");
        university.setType("Private");
        university.setCampusArea(1500.0);
        university.setMinFee(5000.0);
        university.setMaxFee(12000.0);
        university.setProvince("Updated Province");
        university.setCity("Updated City");
        university.setAddress("Updated Address");
        university.setClimate("Updated Climate");
        university.setApplicationDeadline("2021.12.31");

        // Convert the university object to JSON
        String universityJson = objectMapper.writeValueAsString(university);

        // Perform the POST request to update the university information
        ResultActions result = mockMvc.perform(post("/updateUniversity")
                .contentType(MediaType.APPLICATION_JSON)
                .content(universityJson));

        // Verify the response status
        result.andExpect(status().isOk());
    }
}
