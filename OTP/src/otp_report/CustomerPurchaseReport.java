package otp_report;

import java.util.ArrayList;
import java.util.List;

import otp_model.Customer;
import otp_model.Payment;

/**
 * Creates a List that contains customers and the total they paid in a webshop,
 * writing to files is handled by the superclass, this class just provides the
 * data for it.
 */
public class CustomerPurchaseReport extends AbstractCustomerReportCreator {

	public CustomerPurchaseReport(List<Payment> payments, List<Customer> customers) {
		super(payments, customers);
	}

	public List<AbstractReportTemplate> createReportData() {
		List<AbstractReportTemplate> results = new ArrayList<AbstractReportTemplate>();
		for (Customer customer : super.getCustomers()) {
			for (Payment entry : super.getPayments()) {
				if (entry.getWebshopId().equals(customer.getWebshopId())
						&& entry.getCustomerId().equals(customer.getCustomerId())) {
					super.setSumOfPurchases(super.getSumOfPurchases() + entry.getAmount());
				}

			}
			results.add(new CustomerReportTemplate(customer, super.getSumOfPurchases()));
			super.setSumOfPurchases(0);
		}
		return results;
	}

}
