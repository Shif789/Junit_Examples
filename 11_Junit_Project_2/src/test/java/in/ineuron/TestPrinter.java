package in.ineuron;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import in.ineuron.service.Printer;

public class TestPrinter {

	@Test
	public void testSingleton() {
		System.out.println("TestPrinter.testSingleton()");
		Printer p1 = Printer.getInstance();
		Printer p2 = Printer.getInstance();
		
		//assertNotNull(p1,"p1 should not be null");// since the values are now null so this will be a failure 
		//assertNotNull(p2);// this line and below won't be executed since the first line is treated as exception
		
		//Another way to print customized message 
		if (p1==null || p2==null) {
			fail("p1,p2 should not be null");
		}
		
		assertSame(p1, p2);// compares the reference
		//assertEquals(p1, p2);// compares the content 
	}
}
