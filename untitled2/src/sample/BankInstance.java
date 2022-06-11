package sample;

import sourceFiles.Bank;

public class BankInstance {
    private Bank user = new Bank();
    private final static BankInstance INSTANCE = new BankInstance();
    private BankInstance(){}

    public static BankInstance getInstance() {
        return INSTANCE;
    }

    public void setBank(Bank u) {
        this.user = u;
    }

    public Bank getBank() {
        return this.user;
    }
}


