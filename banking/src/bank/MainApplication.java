package bank;

import java.io.IOException;

public class MainApplication {
	public static void main(String[] args) throws IOException {
		BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		BankStatementParser bankStatementParser = new BankStatementCSVParser();
		String path = "C:/Users/jansr/Downloads/Core_Java_Learning/banking/bank-data-simple.csv";
		bankStatementAnalyzer.analyze(path, bankStatementParser);
	}
}
