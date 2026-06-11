package xyz.season.springtime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest // Having used @SpringBootTest, we are asking for the whole application context to be created.
@AutoConfigureMockMvc // Note the use of @AutoConfigureMockMvc and @SpringBootTest to inject a MockMvc instance.
class SpringTimeApplicationTests {

    @Autowired // MockMvc comes from Spring Test and lets you, through a set of convenient builder classes, send HTTP requests into the DispatcherServlet and make assertions about the result.
    private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(get("/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
}
