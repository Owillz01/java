import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    private HashMap<String, Customer> customerDetails = new HashMap<>();

    public void registerCustomer(){
        Scanner input = new Scanner(System.in);
        // try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your First Name");
            String fName = input.nextLine();   

            System.out.println("Enter your Last Name");
            String lName = input.nextLine(); 

            System.out.println("Enter your Age");
            int age = input.nextInt(); 

            Customer customer = new Customer(fName, lName, age);
            customer.toString();
            System.out.println(customer);
            customerDetails.put(customer.getAccountNumber(), customer);
            goBack(input); 
        // }
    }

    private void goBack(Scanner input) {
        System.out.println("0: to go back");
        int opt = input.nextInt(); 
        while (opt != 0) {
            System.out.println("0: to go back");
            opt = input.nextInt(); 
        }
    }
}
