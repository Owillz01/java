import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        String result = generatePassword();
        System.out.println(result);
    }
    

    private static String generatePassword() {
        try (Scanner input = new Scanner(System.in)) {
            Random random = new Random();

            String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

            System.out.println("Enter password length.");
            int length = input.nextInt();
            StringBuilder password = new StringBuilder();

            for(int i=1; i<=length; i++){
                int index = random.nextInt(charPool.length());
                // System.out.println(charPool.charAt(index));
                password.append(charPool.charAt(index));
            }
            
            String result = String.format("Your new password is %1$s",password.toString());
            return result;
            
        }
    }
}
