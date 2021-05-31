package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	public OnlinePaymentService onlinePaymentoService;
	
	public ContractService(OnlinePaymentService onlinePaymentoService) {
		this.onlinePaymentoService = onlinePaymentoService;
	}
	
	public void processContract(Contract contract, Integer months) {
		double basicInterest = contract.getTotalValue() / months;
		double totalInterest;
		Date dueDate;
		
		for (int n = 1; n <= months; n++) {
			
			totalInterest = basicInterest + onlinePaymentoService.interest(basicInterest, n);
			totalInterest += onlinePaymentoService.paymentFee(totalInterest);
			dueDate = addMonths(contract.getDate(), n);
			
			contract.getInstallments().add(new Installment(dueDate, totalInterest));
			
		}
	}
	
	public Date addMonths(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime	();
	}
	
}
