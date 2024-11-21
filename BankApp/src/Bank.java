import java.util.HashMap;
import java.util.Scanner;

public class Bank implements AtmFn {

    private HashMap<String, Customer> customerDetails = new HashMap<>();
    Db db = new Db();

    public void registerCustomer() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your First Name");
        String fName = input.nextLine();

        System.out.println("Enter your Last Name");
        String lName = input.nextLine();

        System.out.println("Enter your Age");
        String age = input.nextLine();

        Customer customer = new Customer(fName, lName, age);
        System.out.println(customer);
        db.insertData(customer.getFirstname(), customer.getLastname(), customer.getAge(), customer.getAccountNumber(), customer.getPIN());
        customerDetails.put(customer.getAccountNumber(), customer);
        goBack(input);
    }

    public void userAuth(Scanner input) {
        System.out.println("Enter your Account Number");
        String accNumber = input.nextLine();
        Customer customer = db.getCustomerInfo(accNumber);
        // System.out.println(customer.toString());
        customerDetails.put(customer.getAccountNumber(), customer);
        if (customerDetails.containsKey(accNumber)) {
            // Customer customer = customerDetails.get(accNumber);
            System.out.println("Enter your Account PIN");
            String pin = input.nextLine();

            if (customer.verifyPin(pin)) {
                String output = String.format("Hello %1$s %2$s", customer.getFirstname(), customer.getLastname());
                System.out.println(output);
                System.out.println("Your Balance is £" + customer.getBalance());
                customer.setIsAuth(true);
                App.currentUser = accNumber;
            } else {
                System.out.println("Invalid PIN!");
            }

        } else {
            System.out.println("Invalid Account Number!");
        }

        goBack(input);
    }

    @Override
    public void checkBalance(Scanner input) {

        Customer customer = customerDetails.get(App.currentUser);
        if (customer.getIsAuth()) {
            System.out.println("Your Balance is £" + customer.getBalance());
        } else {
            System.out.println("User not Authenticated!");
        }

        goBack(input);
    }

    @Override
    public void deposit(Scanner input) {

        Customer customer = customerDetails.get(App.currentUser);

        if (customer.getIsAuth()) {
            System.out.println("Enter your Amount");
            Double amount = Double.parseDouble(input.nextLine());
            customer.setBalance(customer.getBalance() + amount, "");
            System.out.println("Deposit Successful!");
            System.out.println("Your Balance is: " + customer.getBalance());
        } else {
            System.out.println("User not Authenticated!");
        }
        goBack(input);
    }

    @Override
    public void withdraw(Scanner input) {

        Customer customer = customerDetails.get(App.currentUser);

        if (customer.getIsAuth()) {
            System.out.println("Enter your Amount");
            Double amount = Double.parseDouble(input.nextLine());
            Double currentAmount = customer.getBalance();

            if (currentAmount < amount) {
                System.out.println("Balance too Low!!");
            } else {
                customer.setBalance(currentAmount - amount, "");
            }

            System.out.println("Your Balance is: " + customer.getBalance());

        } else {
            System.out.println("User not Authenticated!");
        }

        goBack(input);
    }

    @Override
    public void goBack(Scanner input) {

        System.out.println("0: to go back");

        String opt = input.nextLine();

        while (Integer.parseInt(opt) != 0) {
            System.out.println("0: to go back");
            opt = input.nextLine();
        }

    }

    @Override
    public void updatePIN(Scanner input) {

        Customer customer = customerDetails.get(App.currentUser);

        if (customer.getIsAuth()) {
            System.out.println("Enter OLD PIN");
            String oldPIN = input.nextLine();

            if (customer.verifyPin(oldPIN)) {
                System.out.println("Enter NEW PIN");
                String newPIN = input.nextLine();
                customer.setPIN(newPIN, null);
                System.out.println("PIN updated Successfully!");
                App.currentUser = "";
            }

        } else {
            System.out.println("Incorrect PIN!");
        }

        goBack(input);
    }
}
