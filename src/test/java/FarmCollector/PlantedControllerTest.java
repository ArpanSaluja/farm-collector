package FarmCollector;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class PlantedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPlanted() throws Exception {
        // Arrange
        int userId = 1;

        // Act
        ResultActions result = mockMvc.perform(get("/planted", userId));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    public void addPlanted() throws Exception {
        // Arrange
        String userJson = "{\"farmId\":\"102\",\"plantingArea\":\"20\", \"farmName\":\"testFarm\",\"corpType\":\"corn\", \"expectedAmount\":\"1000\"}";

        // Act
        ResultActions result = mockMvc.perform(post("/planted")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson));

        // Assert
        result.andExpect(status().is2xxSuccessful());
    }
}
