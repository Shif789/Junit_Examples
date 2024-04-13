package in.ineuron.service;

public class CensusService {

	public String exportData() {

		return "Data Exported";
	}

	public boolean isOdd(int num) {
		return num % 2 == 0 ? false : true;
	}
	
	public String sayHello(String user) {
		return "Hello : "+user;
	}
	
	public boolean isItEmpty(String user) {
		return user.isBlank();
	}
}
