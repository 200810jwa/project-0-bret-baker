package com.bbbank.scanner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bbbank.models.Admin;
import com.bbbank.models.Application;
import com.bbbank.models.User;
import com.bbbank.dao.IUserDAO;
import com.bbbank.dao.IAdminDAO;
import com.bbbank.dao.IApplicationDAO;

public class ControlFlowTest {
	
	@Mock
	private IUserDAO mockedDao;
	private IAdminDAO mockedDao1;
	private IApplicationDAO mockedDao2;
	private ControlFlow testInstance = new ControlFlow(mockedDao);
	private ControlFlow testInstance1 = new ControlFlow(mockedDao1);
	private ControlFlow testInstance2 = new ControlFlow(mockedDao2);
	private User bret;
	private Admin bret1;
	private Application bret2;

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		testInstance = new ControlFlow(mockedDao);
		testInstance1 = new ControlFlow(mockedDao1);
		testInstance2 = new ControlFlow(mockedDao2);
		
		bret = new User(1, "bret", "baker", "bb@mail.com", "bb@mail.com", "password", 1, 0, 0);
		bret1 = new Admin(1, "bret1", "baker", "bb1@mail.com", "bb1@mail.com", "password", 1);
		bret2 = new Application(1, "bret2", "baker", "bb2@mail.com", "password", 1, 750, 55000);
		
		when(mockedDao.getByUsername("bb@mail.com")).thenReturn(bret);
		when(mockedDao.getByUsername(anyString())).thenReturn(null);
		when(mockedDao.getById(1)).thenReturn((List<User>) bret);
		when(mockedDao.getByPassword("password")).thenReturn(true);
		when(mockedDao.getCheckingBalance("bb@mail.com")).thenReturn(1.0);
		when(mockedDao.getSavingsBalance("bb@mail.com")).thenReturn(1.0);
		when(mockedDao.updateCheckingBalance("bb@mail.com", 1000.0)).thenReturn(1000.0);
		when(mockedDao.updateSavingsBalance("bb@mail.com", 1000.0)).thenReturn(1000.0);
		when(mockedDao.updateAccountInfo(1, "bret", "baker", "bb@mail.com", "bb@mail.com", "password")).thenReturn(1);
		when(mockedDao.insert("bret", "baker", "bb@mail.com", "bb@mail.com", "password", 1, 0, 0)).thenReturn(1);
		when(mockedDao.delete("bb@mail.com")).thenReturn(true);
		
		
		when(mockedDao1.getByUsername("bb1@mail.com")).thenReturn((List<Admin>) bret1);
		when(mockedDao1.getByPassword("password")).thenReturn(true);
		when(mockedDao1.insert("bret1", "baker", "bb1@mail.com", "bb1@mail.com", "password", 1)).thenReturn(1);
		when(mockedDao1.delete("bb1@mail.com")).thenReturn(true);
		
		when(mockedDao2.getAll()).thenReturn((List<Application>) bret2);
		when(mockedDao2.getByUsername("bb2@mail.com")).thenReturn((List<Application>) bret2);
		when(mockedDao2.insert("bret2", "baker", "bb2@mail.com", "password", 1, 750, 55000)).thenReturn(1);
		when(mockedDao2.delete("bb2@mail.com")).thenReturn(true);
		
	}

//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void testGetUserByUsername() {

//		assertEquals(testInstance.getUserByUsername("bb@mail.com"), bret);
		
	}

	@Test
	public void testAuthUser() {

//		assertEquals(testInstance.authUser("password"), bret);
		
	}

	@Test
	public void testGetAdminByUsername() {

//		assertEquals(testInstance1.getAdminByUsername(), bret1);
		
	}

	@Test
	public void testGetAdminByPassword() {

//		assertEquals(testInstance1.getAdminByPassword(), bret1);
		
	}

}
