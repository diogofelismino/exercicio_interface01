package model.service;

public class PayPalService implements OnlinePaymentService {
	
	public double simpleSwear(double amount, int i) {
		return amount + (amount * 0.01) * i;
	}
	
	public double tax(double amount) {
		return amount + (amount * 0.02);
	}

}
