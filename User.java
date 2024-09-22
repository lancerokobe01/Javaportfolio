public class User {
    private int id;
    private int pin;
    private String name;
    private double balance;

    public User(int id, int pin, String name, double balance) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void cashIn(double amount) {
        this.balance += amount;
        System.out.println("");
        System.out.println("Cash-in successful. New balance: " + balance);
    }

    public void transferMoney(User recipient, double amount) {
        if (amount > balance) {
            System.out.println("");
            System.out.println("Insufficient balance for the transfer.");
        } else {
            this.balance -= amount;
            recipient.setBalance(recipient.getBalance() + amount);
            System.out.println("");
            System.out.println("Transfer successful. Your new balance: " + balance);
        }
    }
}
