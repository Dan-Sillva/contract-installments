package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dueDate;
	private Double amount;
	
	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public String getDueDate() {
		return sdf.format(dueDate);
	}
	
	public Double getAmount() {
		return amount;
	}
}
