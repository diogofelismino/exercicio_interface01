package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}


	public void processContract(Contract contract, int month) {
		double basciPay = contract.getTotalValue() / month;
		for(int i=1; i<=month; i++) {
			Date date = addMonth(contract.getDate(), i);
			double priceSimpleInterest = onlinePaymentService.simpleSwear(basciPay, i);
			double priceTax = onlinePaymentService.tax(priceSimpleInterest);
			
			contract.addInstallment(new Installment(date, priceTax));
			
		}
		
		
	}
	
	
	private Date addMonth(Date data, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, i);
		return cal.getTime();
		
	}

}
