package in.ineuron;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import in.ineuron.dao.ILoginDao;
import in.ineuron.service.ILoginService;
import in.ineuron.service.LoginServiceImpl;

/**
 * Unit test for MockitoUnitTestting-LoginApp.
 */
public class TestLoginServiceImpl {

	private static ILoginDao loginDaoMock;
	private static ILoginService loginService;

	@BeforeAll
	public static void setUp() {
		System.out.println("TestLoginServiceImpl.setUp()");

		// Create a Mock object for DAO class with no implementation
		loginDaoMock = Mockito.mock(ILoginDao.class);
		System.out.println("Implementation class name of ILoginDao is: " + loginDaoMock.getClass().getName());

		// Create a Service class object by using Mock
		loginService = new LoginServiceImpl(loginDaoMock);
	}

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void testLoginWithValidCredentials() {
		System.out.println("TestLoginServiceImpl.testLoginWithValidCredentials()");

		// provide stub (providing functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("shefat", "123")).thenReturn(1);
		boolean actualOutput = loginService.login("shefat", "123");

		// compare the boolean result using assert
		assertTrue(actualOutput);
	}

	@Test
	public void testLoginWithInValidCredentials() {
		System.out.println("TestLoginServiceImpl.testLoginWithInValidCredentials()");

		// provide stub (providing functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("shft", "1234")).thenReturn(0);
		boolean actualOutput = loginService.login("shft", "1234");

		// compare the boolean result using assert
		assertFalse(actualOutput);
	}

	@Test
	public void testLoginWithNoCredentials() {
		System.out.println("TestLoginServiceImpl.testLoginWithNoCredentials()");
		
		assertThrows(IllegalArgumentException.class, ()->loginService.login("", ""));
	}
	
	@Test
	public void testRegisterUserWithSpy() {
		System.out.println("TestLoginServiceImpl.testRegisterUserWithSpy()");
		
		// Create a Spy object for DAO class with no implementation
		ILoginDao loginDaoSpy = Mockito.spy(ILoginDao.class);
		
		System.out.println("Implementation class name of ILoginSpy is: " + loginDaoSpy.getClass().getName());

		
		// Create a Service class object by using Spy
		LoginServiceImpl loginService = new LoginServiceImpl(loginDaoSpy);
		
		loginService.registerUser("shefat", "customer");
		loginService.registerUser("shefat", "");
		loginService.registerUser("shefat", "visitor");
		
		Mockito.verify(loginDaoSpy, Mockito.times(1)).addUser("shefat", "customer");
		Mockito.verify(loginDaoSpy, Mockito.times(0)).addUser("shefat", "");
		Mockito.verify(loginDaoSpy, Mockito.never()).addUser("shefat", "visitor");// same as the above method
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("TestLoginServiceImpl.cleanUp()");
		loginDaoMock = null;
		loginService = null;
	}
}
