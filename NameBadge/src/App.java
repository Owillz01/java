import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {     
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your name");
            String name = input.nextLine();
            System.out.println("Enter your jobTitle");
            String jobTitle = input.nextLine();
            
            System.out.println("Enter your contact");
            String contact = input.nextLine();
            
            Badge nameBadge = new Badge(name, jobTitle, contact);
             System.out.println("======== Your Name Badge =======");
             System.out.println(nameBadge.getName() +" "+ nameBadge.getJobTitle()+" "+nameBadge.getContact());
             System.out.println("\n");
        }
    }
}
