package in.ineuron.service;

public class BankLoanService {

	public BankLoanService() {
		System.out.println("\nBankLoanService:: Zero Param Constructor\n");
	}
	
	public float calculateSimpleInterest(float pAmount, float rate, float time) {
		System.out.println("BankLoanService.calculateSimpleInterest()");

		if (pAmount <= 0 || rate <= 0 || time <= 0)
			throw new IllegalArgumentException("invalid inputs");

		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (pAmount * rate * time) / 100.00f;
	}
}
