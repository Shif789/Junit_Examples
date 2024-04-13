package in.ineuron;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestMockVsSpy {

	@Test
	public void testList() {

		// Mock object for ArrayList class
		ArrayList<String> listMock = Mockito.mock(ArrayList.class);

		// Spy object for ArrayList class
		ArrayList<String> listSpy = Mockito.spy(new ArrayList<String>());

		// Stubbing Mock Object
		Mockito.when(listMock.size()).thenReturn(1);
		
		// Stubbing Spy Object
		Mockito.when(listSpy.size()).thenReturn(1);

		// Mock Object:: dummy implementation will be used
		listMock.add("shefat");
		// Spy Object:: actual implementation of ArrayList will be used
		listSpy.add("shefat");

		System.out.println("Mock object size: " + listMock.size() + ", Spy object size: " + listSpy.size());
	}
}
