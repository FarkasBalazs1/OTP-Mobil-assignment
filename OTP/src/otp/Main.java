package otp;

import java.io.File;
import java.util.List;

import otp_model.Customer;
import otp_model.Payment;
import otp_report.AbstractReportCreator;
import otp_report.CustomerPurchaseReport;
import otp_report.TopSpendingCustomerReport;
import otp_report.WebshopIncomeReport;

public class Main {

	public static void main(String[] args) {

		FileLoader f = new FileLoader();
		List<Customer> customers = f.readCustomersFromFile(new File("src/customer.csv"));
		List<Payment> payments = f.readPaymentsFromFile(new File("src/payments.csv"));
		AbstractReportCreator report = new CustomerPurchaseReport(payments, customers);
		AbstractReportCreator topReport = new TopSpendingCustomerReport(payments, customers);
		AbstractReportCreator webshopReport = new WebshopIncomeReport(payments);

		report.createReport("report01.csv");
		topReport.createReport("top.csv");
		webshopReport.createReport("report02.csv");

	}

}
