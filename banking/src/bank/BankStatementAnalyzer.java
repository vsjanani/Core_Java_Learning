package bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

	List<BankTransactions> bankTransaction = null;
	
	public static void analyze(String strPath, BankStatementParser bankStatementParser) throws IOException {
		final Path path =  Paths.get(strPath);
		final List<String> lines = Files.readAllLines(path);
		System.out.println(lines.get(0));
		List<BankTransactions> bankTransaction = bankStatementParser.parseLinesFrom(lines);
		System.out.println(bankTransaction.get(0).getAmount());
		BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransaction);
		
		
		collectSummary(bankStatementProcessor);

	}

	public static void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("Overall total is" + bankStatementProcessor.calculateTotalAmount());
		System.out.println("Monthwise total is"+ bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("Categorywise total is"+ bankStatementProcessor.calculateTotalForCategory("Salary"));
		List<BankTransactions> bt = bankStatementProcessor.findTransactionsGreaterThanOrEqual(2000);
		for(BankTransactions eachBT : bt) {
			System.out.println(eachBT.getAmount() + eachBT.getDescription() + eachBT.getDates());
		}
		BankTransactionFilter feb = new BankTransactionInFeb();
		bankStatementProcessor.findTransactions(feb).forEach(s->System.out.println("Through interface implementation as separate class it is" + s.getAmount()));
		
		//Above two lines along can be written using lambda expression as below: This is to reduce new interface class creation.
		List<BankTransactions> result = bankStatementProcessor.findTransactions(bankTransaction -> bankTransaction.getDates().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1000);
		result.forEach(s->System.out.println("Through lambda it is" + s.getAmount()));
	}

}
