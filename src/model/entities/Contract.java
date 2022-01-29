package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private int number;
	private Date date;
	private double totalValue;
	
	private List<Installment> installment = new ArrayList<>();
	
	public Contract() {
	}

	public Contract(int number, Date date, double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

	public void setInstallment(List<Installment> installment) {
		this.installment = installment;
	}
	
	public void addInstallment(Installment amount) {
		installment.add(amount);
	}
	
	public void romoveInstallment(Installment amount) {
		installment.remove(amount);
	}
	
}
