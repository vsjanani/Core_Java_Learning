package bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

	public static void analyze(String strPath, BankStatementParser bankStatementParser) throws IOException {
		final Path path =  Paths.get(strPath);
		final List<String> lines = Files.readAllLines(path);
		System.out.println(lines.get(0));
		List<BankTransactions> myList = bankStatementParser.parseLinesFrom(lines);
		System.out.println(myList.get(0).getAmount());
		BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(myList);
		collectSummary(bankStatementProcessor);

	}

	public static void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("Overall total is" + bankStatementProcessor.calculateTotalAmount());
		System.out.println("Monthwise total is"+ bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("Categorywise total is"+ bankStatementProcessor.calculateTotalForCategory("Salary"));
		
	}

}
