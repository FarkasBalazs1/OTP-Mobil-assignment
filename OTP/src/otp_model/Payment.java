package otp_model;

import java.time.LocalDate;

public class Payment {

	private String webshopId;
	private String customerId;
	private PaymentType paymentType;
	private int amount;
	private String bankAccountNumber;
	private String cardNumber;
	private LocalDate paymentDate;

	public Payment(String webshopId, String customerId, PaymentType paymentType, int amount, String bankAccountNumber,
			String cardNumber, LocalDate paymentDate) {
		this.webshopId = webshopId;
		this.customerId = customerId;
		this.paymentType = paymentType;
		this.amount = amount;
		this.bankAccountNumber = bankAccountNumber;
		this.cardNumber = cardNumber;
		this.paymentDate = paymentDate;
	}

	public String getWebshopId() {
		return webshopId;
	}

	public void setWebshopId(String webshopId) {
		this.webshopId = webshopId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Payment [webshopId=" + webshopId + ", customerId=" + customerId + ", paymentType=" + paymentType
				+ ", amount=" + amount + ", bankAccountNumber=" + bankAccountNumber + ", cardNumber=" + cardNumber
				+ ", paymentDate=" + paymentDate + "]";
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
}
