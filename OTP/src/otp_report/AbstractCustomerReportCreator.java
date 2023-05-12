package otp_report;

import java.util.List;

import otp_model.Customer;
import otp_model.Payment;

/**
 * Superclass for the CustomerPurchaseReport and TopSpendingCustomerReport
 * classes
 */
public abstract class AbstractCustomerReportCreator extends AbstractReportCreator {

	private List<Customer> customers;
	private int sumOfPurchases;

	public AbstractCustomerReportCreator(List<Payment> payments, List<Customer> customers) {
		super(payments);
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getSumOfPurchases() {
		return sumOfPurchases;
	}

	public void setSumOfPurchases(int sumOfPurchases) {
		this.sumOfPurchases = sumOfPurchases;
	}

}
