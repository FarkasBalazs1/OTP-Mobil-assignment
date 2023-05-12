package otp_report;

import java.util.ArrayList;
import java.util.List;

import otp_model.Payment;
import otp_model.PaymentType;

/**
 * Creates a List that contains the sum of the income of the webshops per
 * webshop, grouped by payment method. writing to files is handled by the
 * superclass, this class just provides the data for it.
 */
public class WebshopIncomeReport extends AbstractReportCreator {

	public WebshopIncomeReport(List<Payment> payments) {
		super(payments);
	}

	@Override
	protected List<AbstractReportTemplate> createReportData() {
		List<AbstractReportTemplate> results = new ArrayList<AbstractReportTemplate>();
		List<String> webshops = new ArrayList<String>();
		for (Payment p : super.getPayments()) {
			if (!webshops.contains(p.getWebshopId())) {
				webshops.add(p.getWebshopId());
			}
		}
		webshops.sort(null);
		for (int i = 0; i < webshops.size(); ++i) {
			WebshopReportTemplate webshop = new WebshopReportTemplate(webshops.get(i), 0, 0);
			for (Payment entry : super.getPayments()) {
				if (entry.getWebshopId().equals(webshops.get(i)) && entry.getPaymentType() == PaymentType.card) {
					webshop.setSumOfCardPurchases(webshop.getSumOfCardPurchases() + entry.getAmount());
				} else if (entry.getWebshopId().equals(webshops.get(i))
						&& entry.getPaymentType() == PaymentType.transfer) {
					webshop.setSumOfTransferPurchases(webshop.getSumOfTransferPurchases() + entry.getAmount());
				}
			}
			results.add(webshop);
		}
		return results;
	}
}
