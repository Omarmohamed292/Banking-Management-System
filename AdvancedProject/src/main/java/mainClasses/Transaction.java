package mainClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Appends a human-readable transaction record to a local log file. */
public class Transaction {
    private static final Path LOG_FILE = Path.of("transaction.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final boolean withdraw;
    private final double amount;
    private final String accountId;

    public Transaction(boolean withdraw, double amount) {
        this(withdraw, amount, "N/A");
    }

    public Transaction(boolean withdraw, double amount, String accountId) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
        }
        this.withdraw = withdraw;
        this.amount = amount;
        this.accountId = accountId == null ? "N/A" : accountId;
        writeTransaction();
    }

    private void writeTransaction() {
        try {
            Files.writeString(
                    LOG_FILE,
                    LocalDateTime.now().format(FORMATTER) + " | Account: " + accountId +
                            " | Operation: " + (withdraw ? "WITHDRAW" : "DEPOSIT") +
                            " | Amount: " + String.format("%.2f", amount) + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND
            );
        } catch (IOException exception) {
            System.err.println("Unable to write transaction log: " + exception.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Transaction: Operation: " + (withdraw ? "withdraw" : "deposit") + ", Amount: " + amount;
    }
}
