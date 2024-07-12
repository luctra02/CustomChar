package customChar.springboot.restserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import customChar.core.CustomChar;

@AutoConfigureMockMvc
@ContextConfiguration(classes = { CustomCharModelController.class, CustomCharModelApplication.class })
@WebMvcTest
public class CustomCharModelApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testDefaultGet() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customChar")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
        try {
            CustomChar customChar = objectMapper.readValue(result.getResponse().getContentAsString(), CustomChar.class);
            assertEquals("Black", customChar.getColour());
            assertEquals("Male", customChar.getGender());
            assertEquals("null", customChar.getExtras());
        } catch (JsonProcessingException e) {
            ;
        }
    }

}