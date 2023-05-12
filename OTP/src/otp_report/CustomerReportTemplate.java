package otp_report;

import otp_model.Customer;

/** Template for how the data is to be formatted when written to file. */
public class CustomerReportTemplate extends AbstractReportTemplate {

	private Customer customer;
	private int sumOfPurchases = 0;

	public CustomerReportTemplate(Customer customer, int sumOfPurchases) {
		this.customer = customer;
		this.sumOfPurchases = sumOfPurchases;
	}

	@Override
	public String toString() {
		return customer.getName() + ", " + customer.getAddress() + ", " + getSumOfPurchases();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getSumOfPurchases() {
		return sumOfPurchases;
	}

	public void setSumOfPurchases(int sumOfPurchases) {
		this.sumOfPurchases = sumOfPurchases;
	}

}
