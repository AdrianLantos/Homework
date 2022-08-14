package org.fasttrackit.Curs19.transactionapp.model.transaction;

public enum TransactionType {
    BUY, SELL;
    public static TransactionType stringToEnum(String enumName) {
        if (enumName.equalsIgnoreCase("BUY")) {
            return TransactionType.BUY;
        } else if (enumName.equalsIgnoreCase("SELL")) {
            return TransactionType.SELL;
        } else {
            throw new RuntimeException("Type must be Buy or Sell");
        }
    }
}
