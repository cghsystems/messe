package net.cghsystems;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class MesseApplicationTests {

    private MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.standaloneSetup(new MesseApplication()).build();
    }

    @Test
    public void getFair() throws Exception {
        String getRequest = "/jasmin/44075/chris/100000/value/3589";

        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get(getRequest)
                .accept(MediaType.APPLICATION_JSON);

        String expected = "{\"chrisContrib\":2491.0637,\"jasminContrib\":1097.9363}";
        mvc.perform(get)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expected)));
    }
}
