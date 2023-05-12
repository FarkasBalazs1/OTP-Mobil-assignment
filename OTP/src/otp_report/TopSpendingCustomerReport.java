package otp_report;

import java.util.ArrayList;
import java.util.List;

import otp_model.Customer;
import otp_model.Payment;

/**
 * Creates a List that contains the top two customers by the total they paid in
 * a webshop, writing to files is handled by the superclass, this class just
 * provides the data for it. This class needs the result of the createReportData
 * method in the CustomerPurchaseReport class to function
 */
public class TopSpendingCustomerReport extends AbstractCustomerReportCreator {

	public TopSpendingCustomerReport(List<Payment> payments, List<Customer> customers) {
		super(payments, customers);
	}

	private CustomerPurchaseReport report = new CustomerPurchaseReport(super.getPayments(), super.getCustomers());

	public List<AbstractReportTemplate> createReportData() {
		List<AbstractReportTemplate> results = new ArrayList<AbstractReportTemplate>();
		List<AbstractReportTemplate> data = report.createReportData();
		CustomerReportTemplate secondMax = null;
		CustomerReportTemplate max = (CustomerReportTemplate) data.get(0);
		if (data.size() > 1) {
			secondMax = (CustomerReportTemplate) data.get(1);
		}
		for (AbstractReportTemplate entry : data) {
			if (((CustomerReportTemplate) entry).getSumOfPurchases() > max.getSumOfPurchases()) {
				if (max.getSumOfPurchases() > secondMax.getSumOfPurchases()) {
					secondMax = max;
				}
				max = (CustomerReportTemplate) entry;
			} else if (secondMax != null
					&& ((CustomerReportTemplate) entry).getSumOfPurchases() < max.getSumOfPurchases()
					&& ((CustomerReportTemplate) entry).getSumOfPurchases() > secondMax.getSumOfPurchases()) {
				secondMax = (CustomerReportTemplate) entry;
			}

		}
		results.add(max);
		results.add(secondMax);
		return results;
	}

}
