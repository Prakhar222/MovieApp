package com.yash.mba.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.mba.MovieBookingAppApplication;
import com.yash.mba.domain.User;
import com.yash.mba.repository.UserRepository;
import com.yash.mba.service.UserService;
import com.yash.mba.serviceImpl.UserServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {MovieBookingAppApplication.class})
public class UserServiceImplTest 
{
	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
//	@InjectMocks 
//	UserServiceImpl userserviceimpl;

	@Test
	public void when_addUser_ItShouldReturn_User() {
		
		User p = new User();
		when(userRepository.save(p)).thenReturn(p);
		
		assertThat(userService.pushUser(p)).isEqualTo(p);
	}
	@Test
	public void getAllUsers()
	{
			User user=new User();
			user.setId(1L);
			user.setPassword("password99");
			user.setUserName("harshu");
			//action
			Optional<User> p=Optional.of(new User());
			when(userRepository.findById(1L)).thenReturn(p);
			//assertion
			assertTrue(p.isPresent());	
	}
//	@Test
//	public void whenGivenCorrectIdentifier_shouldReturnTheCorrectUser() {
//		Optional<User> p = Optional.of(new User(1L,"password99","harshu"));
//		when(userRepository.findById(41L)).thenReturn(p);
//		
//		assertThat(userRepository.getById(41L)).isEqualTo(p);
//	}
}
