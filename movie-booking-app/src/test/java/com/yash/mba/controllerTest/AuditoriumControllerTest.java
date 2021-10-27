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
import com.yash.mba.web.AuditoriumController;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuditoriumControllerTest {
	@InjectMocks
	AuditoriumController auditoriumController;

	@MockBean
	AuditoriumRepository auditoriumRepository;

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void pushAuditorium() throws Exception
	{
		String Auditorium ="{\r\n"+ "  \"seatCount\": \"42\"\r\n"+ " }";
	
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/auditorium/save")
				.content(Auditorium)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
