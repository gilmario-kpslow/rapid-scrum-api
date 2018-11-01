package br.com.rapidscrum.rapidscrum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RapidscrumApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/status").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
