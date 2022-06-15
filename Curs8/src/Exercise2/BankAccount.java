package Exercise2;

public class BankAccount implements BankAccountInterface {
    int money = 0;

    public BankAccount(int initialDeposit) {
        if (initialDeposit > 0) {
            this.money = initialDeposit;
        }else {
            System.out.println("Please insert a valid amount");
        }
    }

    @Override
    public void withdraw(int withdrawal) {
        if (money < withdrawal) {
            System.out.println("Not enough money. You have " + money + " in your account");
        } else {
            money -= withdrawal;
            System.out.println("You have " + money + " left in your account");
        }
    }

    @Override
    public void deposit(int deposit) {
        money += deposit;
        System.out.println("Total amount in you account is " + money);
    }

}
