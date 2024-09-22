import java.util.Scanner;

public class Bankingapp {
    public static void main(String[] args) {
        User[] users = {
            new User(412435, 7452, "Chris Sandoval", 32000),
            new User(264863, 1349, "Marc Yim", 1000)
        };
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;

        while (loggedInUser == null) {
            System.out.println(" --------------------------- ");
            System.out.println("        Welcome to the       ");
            System.out.println("      B A N K I N G  A P P   ");
            System.out.println("");
            System.out.print("Enter your User ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            for (User user : users) {
                if (user.getId() == id && user.getPin() == pin) {
                    loggedInUser = user;
                    System.out.println("Login successful. Welcome, " + loggedInUser.getName() + "!");
                    break;
                }
            }

            if (loggedInUser == null) {
                System.out.println("");
                System.out.println("    Invalid User ID or PIN. Please try again.");
            }
        }

        int choice;
        do {
            System.out.println("+-------------------------+");
            System.out.println("| Select an option:       |");
            System.out.println("| 1. Check Balance        |");
            System.out.println("| 2. Cash-in              |");
            System.out.println("| 3. Money Transfer       |");
            System.out.println("| 4. Exit                 |");
            System.out.println("+-------------------------+");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loggedInUser.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to cash-in: ");
                    double cashInAmount = scanner.nextDouble();
                    loggedInUser.cashIn(cashInAmount);
                    break;

                case 3:
                    System.out.print("Enter recipient User ID: ");
                    int recipientId = scanner.nextInt();
                    User recipient = null;

                    for (User user : users) {
                        if (user.getId() == recipientId && user != loggedInUser) {
                            recipient = user;
                            break;
                        }
                    }

                    if (recipient != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        loggedInUser.transferMoney(recipient, transferAmount);
                    } else {
                        System.out.println("Recipient not found or invalid transfer.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Banking App. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

