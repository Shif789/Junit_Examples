package in.ineuron;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import in.ineuron.service.CensusService;

public class TestCensusService {

	static CensusService censusService = null;

	@BeforeAll
	public static void setUpOnce() {
		System.out.println("TestCensusService.setUpOnce()");
		censusService = new CensusService();
	}

	// @Test // for repeated tests no need to keep @Test annotation
	@DisplayName("Testing Data Export")
	// @RepeatedTest(value = 3)
	@RepeatedTest(value = 3, name = "execution of {displayName}-{currentRepetition}/{totalRepetitions}")
	public void testExportData() {
		System.out.println("TestCensusService.testExportData()");
		String actual = censusService.exportData();
		String expected = "Data Exported";

		assertEquals(expected, actual);
	}

	// @Test // for parameterized tests no need to keep @Test annotation
	@ParameterizedTest
	@ValueSource(ints = { 10, 21, 24, 15, 7 })
	public void testIsOdd(int data) {
		System.out.println("TestCensusService.testIsOdd() :: " + data);
		boolean actual = censusService.isOdd(data);
		// boolean expected = false;

		assertTrue(actual);
	}

	@ParameterizedTest
	@ValueSource(strings = { "Shifat", "Nadim", "Fares" })
	public void testSayHello(String data) {
		System.out.println("TestCensusService.testSayHello() : " + data);
		String actual = censusService.sayHello(data);
		String expected="Hello : "+data;
		
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	//@NullSource()// passes null as argument -> generates error as result
	//@EmptySource // passes empty string as argument
	@NullAndEmptySource // passes both null and empty string argument
	public void testIsItEmpty(String data) {
		System.out.println("TestCensusService.testIsItEmpty() : " + data);
		boolean actual = censusService.isItEmpty(data);
		//String expected="Hello : "+data;
		
		assertTrue(actual);
	}
	
	@AfterAll
	public static void cleanUp() {
		System.out.println("TestCensusService.cleanUp()");
		censusService = null;
	}
}
