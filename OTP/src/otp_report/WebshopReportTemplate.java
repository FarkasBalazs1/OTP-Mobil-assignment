package otp_report;

/** Template for how the data is to be formatted when written to file. */
public class WebshopReportTemplate extends AbstractReportTemplate {

	private String webshopId;
	private int sumOfCardPurchases = 0;
	private int sumOfTransferPurchases = 0;

	public WebshopReportTemplate(String webshopId, int sumOfCardPurchases, int sumOfTransferPurchases) {
		this.webshopId = webshopId;
		this.sumOfCardPurchases = sumOfCardPurchases;
		this.sumOfTransferPurchases = sumOfTransferPurchases;
	}

	@Override
	public String toString() {
		return webshopId + ", sumOfCardPurchases= " + sumOfCardPurchases + ", sumOfTransferPurchases= "
				+ sumOfTransferPurchases;
	}

	public String getWebshopId() {
		return webshopId;
	}

	public void setWebshopId(String webshopId) {
		this.webshopId = webshopId;
	}

	public int getSumOfCardPurchases() {
		return sumOfCardPurchases;
	}

	public void setSumOfCardPurchases(int sumOfCardPurchases) {
		this.sumOfCardPurchases = sumOfCardPurchases;
	}

	public int getSumOfTransferPurchases() {
		return sumOfTransferPurchases;
	}

	public void setSumOfTransferPurchases(int sumOfTransferPurchases) {
		this.sumOfTransferPurchases = sumOfTransferPurchases;
	}

}
