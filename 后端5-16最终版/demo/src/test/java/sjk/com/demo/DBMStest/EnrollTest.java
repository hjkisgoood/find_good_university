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
import sjk.com.demo.entity.Users;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class EnrollTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testUserRegistration() throws Exception {
        // Create a sample user object for registration
        Users user = new Users();
        user.setUsername("sample_username");
        user.setPassword("sample_password");
        user.setUserType("普通⽤户");
        user.setName("Sample User");
        user.setDocumentType("ID");
        user.setDocumentNumber("123456789");
        user.setPhoneNumber("1234567890");
        user.setEmail("sample@example.com");
        user.setUserIntro("Sample introduction");
        user.setCity("Sample City");

        // Convert the user object to JSON
        String userJson = objectMapper.writeValueAsString(user);

        // Perform the POST request to register the user
        ResultActions result = mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson));

        // Verify the response status and content
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("User registered successfully"))
                .andExpect(jsonPath("$.userId").isString());
    }
}
