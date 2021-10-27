//package com.yash.mba.repositoryTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//import org.junit.Rule;
//import org.junit.jupiter.api.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.yash.mba.domain.Admin;
//import com.yash.mba.repository.AdminRepository;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
//@ContextConfiguration 
//public class AdminRepositoryTest 
//{
//	@MockBean
//	private AdminRepository adminRepository;
//	
//	@Rule
//	public ExpectedException expectedEx = ExpectedException.none();
//	@Test
//	public void SaveAdminTest() {
////		Admin admin=adminRepository.save(new Admin(1L,"harshada","harsha@gmail.com","password11"));
//		Admin p = new Admin(1L,"harshada","harsha@gmail.com","password11");
//		when(adminRepository.save(p)).thenReturn(p);
//		
//		assertThat(adminRepository.save(p)).isEqualTo(p);
//	}
//}
