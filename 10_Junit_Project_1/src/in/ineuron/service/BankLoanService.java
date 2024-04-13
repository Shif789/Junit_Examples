package in.ineuron.service;

public class BankLoanService {

	public float calculateSimpleInterest(float pAmount, float rate, float time) {
		
		return (pAmount * rate * time) / 100.00f;
	}
}
