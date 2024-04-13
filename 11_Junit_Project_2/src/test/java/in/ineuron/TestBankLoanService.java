package in.ineuron;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer.Random;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import in.ineuron.service.BankLoanService;

//import static org.junit.Assert.assertTrue;

//import org.junit.Test;

/**
 * Unit test for simple App.
 */
@TestMethodOrder(value = OrderAnnotation.class)// without this orders will not work
//@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)// both works
//@TestMethodOrder(value = MethodName.class)// order will be based on method names
//@TestMethodOrder(value = org.junit.jupiter.api.MethodOrderer.DisplayName.class)// order will be based on display names
//@TestMethodOrder(value = Random.class)// order will be random
public class TestBankLoanService {
	private static BankLoanService bankLoanService;

	//@BeforeEach
	@BeforeAll
	public static void  setUp() {
		System.out.println("\nTestBankLoanService.setUp()");
		bankLoanService = new BankLoanService();
	}

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Tag(value = "dev")
	//@Tag(value = "uat")// tag is repeatable
	@DisplayName("Testing with small numbers")
	@Test
	@Order(1)
	public void testCalculateSimpleInterestWithSmallNumbers(TestInfo testInfo) {
		System.out.println("\nTestBankLoanService.testCalculateSimpleInterestWithSmallNumbers(), "+testInfo.getTestClass()+", "+testInfo.getTags());
		// BankLoanService bankLoanService = new BankLoanService();
		float actualOutput = bankLoanService.calculateSimpleInterest(100000, 2, 12);
		float expectedOutput = 24000.0f;

		// Method checking for test case and generating output
		assertEquals(expectedOutput, actualOutput);
	}

	@Tag(value = "uat")
	@DisplayName("Testing with big numbers")
	@Test
	@Order(2)
	public void testCalculateSimpleInterestWithBigNumbers() {
		System.out.println("\nTestBankLoanService.testCalculateSimpleInterestWithBigNumbers()");
		// BankLoanService bankLoanService = new BankLoanService();
		float actualOutput = bankLoanService.calculateSimpleInterest(10000000, 2, 12);
		float expectedOutput = 2400000.325f;// if dp are big then it will count as failure

		// Method checking for test case and generating output
		// assertEquals(expectedOutput, actualOutput);
		// assertEquals(expectedOutput, actualOutput,"Results are not matching");//
		// overloaded method to customize the failure message
		assertEquals(expectedOutput, actualOutput, 0.5f, "Results are not matching");// delta=> even if dp is big delta
																						// will count it as pass
	}

	@Tag("dev")// both are same
	@Test
	public void testCalculateSimpleInterestWithInvalidInputs() {
		System.out.println("\nTestBankLoanService.testCalculateSimpleInterestWithInvalidInputs()");
		// BankLoanService bankLoanService = new BankLoanService();
//		float actualOutput = bankLoanService.calculateSimpleInterest(0, 2, 12);
//		float expectedOutput=2400000.0f;

		// Method checking for test case and generating output
		// assertThrows(IllegalArgumentException.class, ()->
		// bankLoanService.calculateSimpleInterest(0, 0, 0));// overloaded method
		assertThrows(IllegalArgumentException.class, () -> bankLoanService.calculateSimpleInterest(0, 0, 0),
				"Exception types are not matching");
	}

	@Disabled // test method won't participate
	@Test
	public void testCalculateSimpleInterestWithInvalidInputs2() {
		System.out.println("\nTestBankLoanService.testCalculateSimpleInterestWithInvalidInputs2()");
		// BankLoanService bankLoanService = new BankLoanService();
		float actualOutput = bankLoanService.calculateSimpleInterest(0, 0, 0);
		float expectedOutput = 2400000.0f;

		// Method checking for test case and generating output
		// assertThrows(IllegalArgumentException.class, ()->
		// bankLoanService.calculateSimpleInterest(0, 0, 0));// overloaded method
		// assertThrows(IllegalArgumentException.class, ()->
		// bankLoanService.calculateSimpleInterest(0, 0, 0),"Exception types are not
		// matching");
		assertEquals(expectedOutput, actualOutput);// since we are not handling the exception this will lead to failure
	}

	@Tag("dev")
	@Test
	public void testCalculateSimpleInterestWithTimer() {
		System.out.println("\nTestBankLoanService.testCalculateSimpleInterestWithTimer()");
		// BankLoanService bankLoanService = new BankLoanService();

		// Method checking for test case and generating output
		assertTimeout(Duration.ofMillis(20000), () -> bankLoanService.calculateSimpleInterest(120000, 2, 3),
				"Time limit failed");
	}

	//@AfterEach
	@AfterAll
	public static void cleanUp() {
		System.out.println("\nTestBankLoanService.cleanUp()\n");
		bankLoanService=null;
	}
}
