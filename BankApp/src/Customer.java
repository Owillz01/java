import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Customer extends Person {
    private String accountNumber;
    public static String sortCode = "55-23-08";
    public static Set<String> accountSet = new HashSet<>();
    private String defaultPin;

    public Customer(String firstname, String lastname, int age){
        super(firstname, lastname, age);
        String number;
        do {
            number = generateAccountNo();
        } while (Customer.accountSet.contains(number));
        setAccountNumber(number);
        setDefaultPin();
        Customer.accountSet.add(number);
        System.out.println(Customer.accountSet);
    }

    private String generateAccountNo(){
        Random random = new Random();
        String num = "";
         for(int i=1; i<=8; i++){
             num += random.nextInt(10);
            }
            // System.out.println(num+" num");
        return num;
    }

    private String generateDefaultPIN(){
        Random random = new Random();
        String pin = "";
         for(int i=1; i<=4; i++){
             pin += random.nextInt(10);
            }
            // System.out.println(num+" num");
        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDefaultPin() {
        return defaultPin;
    }

    private void setDefaultPin() {
        this.defaultPin = generateDefaultPIN();
    }

    @Override
    public String toString() {
        String output = String.format("Hello %1$s %2$s your account number is %3$s, sort code is %4$s and your default pin is %5$s",getFirstname(), getLastname(), accountNumber, Customer.sortCode, defaultPin);
        return output;
    }

}
