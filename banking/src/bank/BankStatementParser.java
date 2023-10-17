package bank;

import java.util.List;

public interface BankStatementParser {
	BankTransactions parseFrom(String line);
	List<BankTransactions> parseLinesFrom(List<String> lines);

}
