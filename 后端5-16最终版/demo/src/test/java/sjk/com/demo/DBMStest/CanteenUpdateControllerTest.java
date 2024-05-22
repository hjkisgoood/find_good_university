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
import sjk.com.demo.entity.Canteens;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CanteenUpdateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testUpdateCanteen() throws Exception {
        // Create a sample canteen object with updated information
        Canteens canteen = new Canteens();
        canteen.setCanteenId(9L); // Set the canteen ID of the canteen to be updated
        canteen.setAverageMealPrice(25.0);
        canteen.setHasSichuan(true);
        canteen.setHasShandong(false);
        canteen.setHasGuangdong(true);

        // Convert the canteen object to JSON
        String canteenJson = objectMapper.writeValueAsString(canteen);

        // Perform the POST request to update the canteen information
        ResultActions result = mockMvc.perform(post("/updateCanteen")
                .contentType(MediaType.APPLICATION_JSON)
                .content(canteenJson));

        // Verify the response status
        result.andExpect(status().isOk());
    }
}

