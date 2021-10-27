package com.yash.mba.controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.yash.mba.repository.AuditoriumRepository;
import com.yash.mba.repository.MovieRepository;
import com.yash.mba.web.AuditoriumController;
import com.yash.mba.web.MovieController;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {
	@InjectMocks
	MovieController movieController;

	@MockBean
	MovieRepository movieRepository;

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void pushMovie() throws Exception
	{
		String Movie =" {\r\n"
				+ "        \"title\": \"title4\",\r\n"
				+ "        \"poster\": \"poster4\",\r\n"
				+ "        \"genre\": \"mack\",\r\n"
				+ "        \"duration\": 3\r\n"
				+ "    }";
	
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/movie/save")
				.content(Movie)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
