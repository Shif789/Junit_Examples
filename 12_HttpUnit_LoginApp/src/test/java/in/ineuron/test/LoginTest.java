package in.ineuron.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTest {
	private static WebConversation conversation;

	@BeforeAll
	public static void setup() {
		System.out.println("LoginTest.setup()");
		conversation = new WebConversation();
	}

	@Test
	public void testWithValidCredentials() throws IOException, SAXException {
		System.out.println("LoginTest.testWithValidCredentials()");
		
		// get response by sending the request to the URL
		String URL = "http://localhost:9999/Http-LoginApp/index.html";
		WebResponse response = conversation.getResponse(URL);

		// get access to the form from the response
		WebForm webForm = response.getForms()[0];

		// setting the request param values to the form object
		webForm.setParameter("uname", "shefat");
		webForm.setParameter("password", "1234");

		// submit the form to get the response
		WebResponse actualResponse = webForm.submit();

		// get the output from the actual response object
		String actualOutput = actualResponse.getText().trim();
		String expectedOutput = "valid credentials";

		// perform assertion to validate the output
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testWithInvalidCredentials() throws IOException, SAXException {
		System.out.println("LoginTest.testWithInvalidCredentials()");
		
		// get response by sending the request to the URL
		String URL = "http://localhost:9999/Http-LoginApp/index.html";
		WebResponse response = conversation.getResponse(URL);

		// get access to the form from the response
		WebForm webForm = response.getForms()[0];

		// setting the request param values to the form object
		webForm.setParameter("uname", "shfat");
		webForm.setParameter("password", "123");

		// submit the form to get the response
		WebResponse actualResponse = webForm.submit();

		// get the output from the actual response object
		String actualOutput = actualResponse.getText().trim();
		String expectedOutput = "invalid credentials";

		// perform assertion to validate the output
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	public void testWithNoCredentials() throws IOException, SAXException {
		System.out.println("LoginTest.testWithNoCredentials()");
		
		// get response by sending the request to the URL
		String URL = "http://localhost:9999/Http-LoginApp/index.html";
		WebResponse response = conversation.getResponse(URL);

		// get access to the form from the response
		WebForm webForm = response.getForms()[0];

		// setting the request param values to the form object
		webForm.setParameter("uname", "");
		webForm.setParameter("password", "");

		// submit the form to get the response
		WebResponse actualResponse = webForm.submit();

		// get the output from the actual response object
		String actualOutput = actualResponse.getText().trim();
		String expectedOutput = "provide credentials";

		// perform assertion to validate the output
		assertEquals(expectedOutput, actualOutput);

	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("LoginTest.cleanUp()");
	}
}
