package otp_report;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import otp_model.Payment;

/**
 * Superclass for the AbstractCustomerReportCreator class, this class contains
 * the methods to write the reports to files. These methods are used by every
 * reporting class
 */
public abstract class AbstractReportCreator {
	private List<Payment> payments;

	public AbstractReportCreator(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public void writeReportToFile(List<AbstractReportTemplate> data, String fileName) {

		try {
			FileWriter fileWriter = new FileWriter(fileName);
			for (AbstractReportTemplate entry : data) {
				fileWriter.write(entry.toString().concat("\n"));
			}
			fileWriter.close();
		} 
		catch (IOException e) {

		}
	}

	public void createReport(String fileName) {
		writeReportToFile(createReportData(), fileName);
	}

	protected abstract List<AbstractReportTemplate> createReportData();

}
