import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opt;
        Bank bank = new Bank();
        try (Scanner mainInput = new Scanner(System.in)) {
            do {
                opt = displayOptions(mainInput);
                switch (opt) {
                    case 1:
                        bank.registerCustomer();
                        break;
                    default:
                        break;
                }
            } while (opt != 5);
        }

    }

    private static int displayOptions(Scanner input){
        System.out.println("Kindly enter the correct number Optioin below.");
        System.out.println("1. Account Opening");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Exit");
        int opt = input.nextInt(); 
        return opt;
    }
}
