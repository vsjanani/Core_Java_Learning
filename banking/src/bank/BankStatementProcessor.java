package bank;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<BankTransactions> findTransactionsGreaterThanOrEqual(Integer amount){
		List<BankTransactions> result = bankTransactions.stream().filter(s->s.getAmount()>=amount).collect(Collectors.toList());
		return result;
		
	}
	
	public List<BankTransactions> findTransactions(BankTransactionFilter bankTransactionFilter) {
		List<BankTransactions> result = bankTransactions.stream().filter(s->bankTransactionFilter.test(s)).collect(Collectors.toList()); 
		return result;
	}
}
