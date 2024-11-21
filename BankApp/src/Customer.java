import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.mindrot.jbcrypt.BCrypt;

public class Customer extends Person {

    private String accountNumber;
    public static String sortCode = "55-23-08";
    public static Set<String> accountSet = new HashSet<>();
    private String defaultPin;
    private String displayPin;
    private double balance = 0.00;
    private Boolean isAuth = false;
    Db db = new Db();
    
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


    //onstructor overloading
    public Customer(String firstname, String lastname, String age, String pin, String number, double balance ) {
        super(firstname, lastname, age);
        setAccountNumber(number);
        setPIN(pin);
        setBalance(balance);
        Customer.accountSet.add(number);
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
        return this.defaultPin;
    }

    public void setPIN(String pin, String state) {
        String hashedPin = hashPin(pin);
        if (db.updatePIN(hashedPin, getAccountNumber())) {
            this.displayPin = pin;
            this.defaultPin = hashedPin;
        }
    }

    public void setPIN(String pin) {

        if (pin.length() > 4) {
            this.defaultPin = pin;
        } else {
            this.displayPin = pin;
            this.defaultPin = hashPin(pin);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance, String state) {
        if (db.updateBalance(balance, getAccountNumber())) {
            this.balance = balance;
        }
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

    public String hashPin(String pin) {
        String hashedPin =  BCrypt.hashpw(pin, BCrypt.gensalt());
        return hashedPin;
    }

    public boolean verifyPin(String plainPin ) {
        String hashedPin = getPIN();
        return BCrypt.checkpw(plainPin, hashedPin);
    }

    @Override
    public String toString() {

        String output = String.format(
                "Hello %1$s %2$s your account number is %3$s, sort code is %4$s, your default pin is %5$s and your balance is £%6$s",
                getFirstname(), getLastname(), accountNumber, Customer.sortCode, displayPin, balance);
                InfoLogger.log(output);
        return output.toString();

    }

}
