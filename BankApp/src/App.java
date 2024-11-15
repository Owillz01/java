import java.util.Scanner;

public class App {
    public static String currentUser = "";

    public static void main(String[] args) throws Exception {

        int opt;
        Bank bank = new Bank();
        
        try (Scanner mainInput = new Scanner(System.in)) {

            do {

                opt = displayOptions(mainInput);
                switch (opt) {
                    case 1:
                    if (!App.currentUser.equals("")) {
                        bank.checkBalance(mainInput);
                    } else {
                        bank.registerCustomer();
                    }
                    break;
                    case 2:
                    if (!App.currentUser.equals("")) {
                        bank.deposit(mainInput);
                    } else {
                            System.out.println(App.currentUser+" App.currentUser");
                            bank.userAuth(mainInput);
                        }
                        break;
                    case 3:
                        if (!App.currentUser.equals("")) {
                            bank.withdraw(mainInput);
                        }
                        break;
                    case 4:
                        if (!App.currentUser.equals("")) {
                            bank.updatePIN(mainInput);
                        }
                        break;
                    default:
                        break;

                }

            } while (opt != 0);

        }

    }

    private static int displayOptions(Scanner input) {

        System.out.println("Kindly enter the correct number Optioin below.");

        if (!App.currentUser.equals("")) {

            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");

        } else {

            System.out.println("1. Account Opening");
            System.out.println("2. Authenticate");

        }

        System.out.println("0. Exit");
        String opt = input.nextLine();
        return Integer.parseInt(opt);

    }
}
