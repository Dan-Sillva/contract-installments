package services;

public class PaypalService implements OnlinePaymentService {
	
	public static final double PAYMENT_FEE = 0.02;
	public static final double INTEREST = 0.01;
	
	@Override
	public Double interest(Double amount, Integer months) {
		return amount * INTEREST * months;
	}
	
	@Override
	public Double paymentFee(Double amount) {
		return amount * PAYMENT_FEE;
	}
	
}
