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

import com.yash.mba.repository.ScreeningRepository;
import com.yash.mba.web.ScreeningController;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ScreeningControllerTest {
	@InjectMocks
	ScreeningController screeningController;

	@MockBean
	ScreeningRepository screeningRepository;

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void pushScreening() throws Exception
	{
		String Screening =" { \r\n"
				+ "        \"date\": \"2022-10-15\",\r\n"
				+ "        \"startTime\": \"00:00:09\",\r\n"
				+ "        \"endTime\": \"00:00:12\",\r\n"
				+ "        \"isFull\": true,\r\n"
				+ "        \"price\": 1200.0\r\n"
				+ "    }";
	
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/auditorium/save")
				.content(Screening)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
