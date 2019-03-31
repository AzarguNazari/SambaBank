package DOA;

import java.util.Date;

public class Transaction {
    
    
    private final String type;
    private final Date date;
    private final double totalBalance;

    public Transaction(String type, Date date, double totalBalance) {
        this.type = type;
        this.date = date;
        this.totalBalance = totalBalance;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" + "type=" + type + ", date=" + date + ", totalBalance=" + totalBalance + '}';
    }
    
    
    
}
