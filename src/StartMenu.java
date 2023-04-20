import java.util.Scanner;
import java.util.ArrayList;

public class StartMenu {

    private ArrayList<Flight> flight;
    public void menu (Scanner input,ArrayList<Flight> flight) {

        int ChoseMenu = 0;
        while (ChoseMenu == 0) {

            printMainMenu();
            ChoseMenu = input.nextInt();
            input.nextLine();

            if (ChoseMenu == 1) {
                // Sign in menu
                System.out.println("Enter user name");
                System.out.print(">>>> ");
                String ActiveUserName = input.nextLine();
                // Check for the valid user
                System.out.println("Enter user Password");
                System.out.print(">>>> ");
                String ActiveUserPassword = input.nextLine();
                if (ActiveUserName.equals("Admin") && ActiveUserPassword.equals("admin")) {
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.mainAdminMenu(input,flight);

                }

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

    public void printMainMenu () {

        // Starting menu
        System.out.println("===================================================");
        System.out.println("============= AirLine Ticket System ===============");
        System.out.println("===================================================");
        System.out.println();
        System.out.println("<1> Sign in");
        System.out.println("<1> Sign up");
        System.out.println();
        System.out.print(">>>> ");
    }


}
