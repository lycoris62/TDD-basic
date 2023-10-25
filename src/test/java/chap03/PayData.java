package chap03;

import java.time.LocalDate;

public class PayData {
	private LocalDate firstBillingDate;
	private LocalDate billingDate;
	private int payAmount;

	private PayData() {}

	public PayData(LocalDate billingDate, int paymentAmount) {
		this.billingDate = billingDate;
		this.payAmount = paymentAmount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public LocalDate getFirstBillingDate() {
		return firstBillingDate;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private PayData data = new PayData();

		public Builder billingData(LocalDate billingData) {
			data.billingDate = billingData;
			return this;
		}

		public Builder payAmount(int payAmount) {
			data.payAmount = payAmount;
			return this;
		}

		public PayData build() {
			return data;
		}

		public Builder firstBillingDate(LocalDate firstBillingDate) {
			data.firstBillingDate = firstBillingDate;
			return this;
		}
	}
}
