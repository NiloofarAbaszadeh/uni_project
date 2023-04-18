import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> flight = new ArrayList();
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();


        int ChoseMenu = 0;
        while (ChoseMenu == 0) {

            // Starting menu
            System.out.println("===================================================");
            System.out.println("============= AirLine Ticket System ===============");
            System.out.println("===================================================");
            System.out.println();
            System.out.println("<1> Sign in");
            System.out.println("<1> Sign up");
            System.out.println();
            System.out.print(">>>> ");

            ChoseMenu = input.nextInt();
            System.out.println();

            if (ChoseMenu == 1) {
                // Sign in menu
                System.out.println("Enter user name");
                System.out.print(">>>> ");
                String ActiveUserName = input.nextLine();
                // Check for the valid user
                System.out.println();
                System.out.println("Enter user name");
                System.out.print(">>>> ");
                String ActiveUserPassword = input.nextLine();
                String ActiveUser = input.nextLine();

            } else if (ChoseMenu == 2) {
                // Sign up menu
                System.out.println("Enter the new user`s name");
                System.out.print(">>>> ");

            } else {
                ChoseMenu = 0;
                System.out.println("please chose a valid number");
            }
        }
    }
}