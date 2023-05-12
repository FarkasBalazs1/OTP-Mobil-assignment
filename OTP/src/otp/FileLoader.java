package otp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import otp_logging.Logger;
import otp_model.Customer;
import otp_model.Payment;
import otp_model.PaymentType;

/**
 * Class for loading the provided csv files into memory
 */
public class FileLoader {

	private List<String> errors = new ArrayList<>();

	public FileLoader() {
	}

	public List<Customer> readCustomersFromFile(File file) {
		String line = "";
		List<Customer> result = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				try {
					String[] data = line.split(";");
					result.add(new Customer(data[0], data[1], data[2], data[3]));
				}

				catch (Exception e) {
					errors.add("Error encountered at line: " + line + " " + e.toString());
					continue;
				}

			}
			br.close();
		} catch (IOException e) {
			errors.add("File error:" + " " + e.toString());
		}
		Logger.getInstance().logErrors(errors);
		return result;
	}

	public List<Payment> readPaymentsFromFile(File file) {
		String line = "";
		List<Payment> result = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				LocalDate date = null;
				String[] data = line.split(";");
				try {
					date = LocalDate.parse(data[6].replace('.', '-'));
					if (data[2].equals(PaymentType.card.toString())) {
						result.add(new Payment(data[0], data[1], PaymentType.card, Integer.parseInt(data[3]), data[4],
								data[5], date));
					} else if (data[2].equals(PaymentType.transfer.toString())) {
						result.add(new Payment(data[0], data[1], PaymentType.transfer, Integer.parseInt(data[3]),
								data[4], data[5], date));
					}
				} catch (Exception e) {
					errors.add("Error encountered at line: " + line + " " + e.toString());
					continue;
				}
			}
			br.close();
		} catch (IOException e) {
			errors.add("File error:" + " " + e.toString());
		}
		Logger.getInstance().logErrors(errors);
		return result;
	}

}
