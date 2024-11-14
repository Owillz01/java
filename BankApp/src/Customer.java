import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Customer extends Person {

    private String accountNumber;
    public static String sortCode = "55-23-08";
    public static Set<String> accountSet = new HashSet<>();
    private String defaultPin;
    private double balance = 0.00;
    private Boolean isAuth = false;

    public Customer(String firstname, String lastname, String age) {

        super(firstname, lastname, age);
        String number;

        do {

            number = generateAccountNo();
        } while (Customer.accountSet.contains(number));

        setAccountNumber(number);
        String pin = generateDefaultPIN();
        setPIN(pin);
        Customer.accountSet.add(number);
        System.out.println(Customer.accountSet);

    }

    private String generateAccountNo() {

        Random random = new Random();
        String num = "";

        for (int i = 1; i <= 8; i++) {
            num += random.nextInt(10);
        }
        return num;
    }

    private String generateDefaultPIN() {

        Random random = new Random();

        String pin = "";
        for (int i = 1; i <= 4; i++) {
            pin += random.nextInt(10);
        }

        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPIN() {
        return defaultPin;
    }

    public void setPIN(String pin) {
        this.defaultPin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    @Override
    public String toString() {

        String output = String.format(
                "Hello %1$s %2$s your account number is %3$s, sort code is %4$s, your default pin is %5$s and your balance is £%6$s",
                getFirstname(), getLastname(), accountNumber, Customer.sortCode, defaultPin, balance);
        return output.toString();

    }

}
