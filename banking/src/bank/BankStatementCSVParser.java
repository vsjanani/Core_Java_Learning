package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	List<BankTransactions> bankTransactions = new ArrayList<BankTransactions>();

	@Override
	public BankTransactions parseFrom(String line) {
		// TODO Auto-generated method stub
		String[] columns = line.split(",");
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		BankTransactions bt = new BankTransactions(date, amount, description);
		return bt;

	}

	@Override
	public List<BankTransactions> parseLinesFrom(List<String> lines) {
		for (String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;

	}
	
	public void dumme() {
		System.out.println("hey");
	}

}

/*
 * another easy way of doing with one method is below: private static final
 * DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
 * List<BankTransactions> bankTransactions = new ArrayList<BankTransactions>();
 * 
 * public List<BankTransactions> parseLinesFromCSV(final List<String> lines) {
 * for (String line : lines) { String[] columns = line.split(","); final
 * LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN); final double
 * amount = Double.parseDouble(columns[1]); final String description =
 * columns[2]; BankTransactions bt = new BankTransactions(date, amount,
 * description); bankTransactions.add(bt);
 * 
 * } return bankTransactions;
 * 
 * }
 * 
 * }
 */