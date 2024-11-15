import java.util.Scanner;

public interface AtmFn {
    public void checkBalance(Scanner input);

    public void deposit(Scanner input);

    public void withdraw(Scanner input);

    public void goBack(Scanner input);

    public void updatePIN(Scanner input);
}
