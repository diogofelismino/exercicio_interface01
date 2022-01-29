package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PayPalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Enter contract data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Date (dd/MM/yyyy): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Contract value: ");
			double totalValue = sc.nextDouble();
			
			Contract contract = new Contract(number, date, totalValue);
			
			System.out.print("Enter number of installments: ");
			int i = sc.nextInt();
			
			ContractService contractService = new ContractService(new PayPalService());
			contractService.processContract(contract, i);
			
			System.out.println();
			System.out.println("Installments: ");
			for(Installment c: contract.getInstallment()) {
				System.out.print(sdf.format(c.getDueDate()) + " - " + String.format("%.2f", c.getAmount()) + "\n");
			}
		}
		catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
		
	}

}
