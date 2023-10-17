package bank;

import java.time.LocalDate;

public class BankTransactions {
	private final LocalDate dates;
	private final double amount;
	private final String description;

	public BankTransactions(final LocalDate dates, final double amount, final String description) {
		this.dates = dates;
		this.amount = amount;
		this.description = description;
	}

	public LocalDate getDates() {
		return dates;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

}
