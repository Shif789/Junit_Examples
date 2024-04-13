package in.ineuron.service;

// singleton class
public class Printer {

	private static Printer INSTANCE = new Printer();
	//private static Printer INSTANCE ;
	
	private Printer() {
	 System.out.println("Printer.Printer()");	
	}
	
	public static Printer getInstance() {
		return INSTANCE;
	}
}
