package bank;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
	private final List<BankTransactions> bankTransactions;

	public BankStatementProcessor(List<BankTransactions> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	
	public Double calculateTotalAmount() {
		Double total = bankTransactions.stream().mapToDouble(s->s.getAmount()).sum();
		return total;
	}
	
	public Double calculateTotalInMonth(final Month month) {
		Double total = bankTransactions.stream().filter(s->s.getDates().getMonth()==month).mapToDouble(s->s.getAmount()).sum();
		return total;
	}
	
	public Double calculateTotalForCategory(final String category) {
		Double total = bankTransactions.stream().filter(s->s.getDescription().equals(category)).mapToDouble(s->s.getAmount()).sum();
		return total;
	}
}
