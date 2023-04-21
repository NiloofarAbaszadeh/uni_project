import java.util.Scanner;
import java.util.ArrayList;

public class StartMenu {

    public void menu (Scanner input, ArrayList<Flight> flight, ArrayList<Passenger> passengers, ArrayList<Tickets> tickets) {


        while (true) {

            int ChoseMenu = 0;
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
                for (int i = 0; i < passengers.size(); i++) {
                    if (ActiveUserName.equals(passengers.get(i).getPassengerName())) {
                        if (ActiveUserPassword.equals(passengers.get(i).getPassengerPassword())) {
                            PassengerMenu passengerMenu = new PassengerMenu();
                            passengerMenu.mainPassengerMenu(ActiveUserName, input, flight, passengers, tickets);
                            System.out.println();
                        }
                    } else if (passengers.size() == i) {
                        System.out.println("User not found");
                        System.out.println();
                    }

                }


            } else if (ChoseMenu == 2) {
                // Sign up menu
                System.out.println("Enter the new user`s name");
                System.out.print(">>>> ");
                String newUserName = input.nextLine();
                System.out.println("Enter the new user`s Password");
                System.out.print(">>>> ");
                String newUserPassword = input.nextLine();
                Passenger passengers01 = new Passenger(newUserName, newUserPassword);
                passengers.add(passengers01);
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
        System.out.println("<2> Sign up");
        System.out.println();
        System.out.print(">>>> ");
    }
    public void addFirstTenFlights (ArrayList<Flight> flight) {
        Flight flight01 = new Flight("WX-09","Tehran","Qazvin",1,45 ,"1402-01-03",45 ,95);
        flight01.setOriginalSeats(flight01.getSeat());
        flight.add(flight01);
        Flight flight02 = new Flight("YZ-32","Ardakan","Rasht",13,15 ,"1402-01-04",31 ,90);
        flight02.setOriginalSeats(flight02.getSeat());
        flight.add(flight02);
        Flight flight03 = new Flight("XH-11","AliAbad","Shiraz",21,5 ,"1402-01-05",14 ,140);
        flight03.setOriginalSeats(flight03.getSeat());
        flight.add(flight03);
        Flight flight04 = new Flight("MA-10","Mashhad","Abadeh",4,25 ,"1402-01-06",110 ,400);
        flight04.setOriginalSeats(flight04.getSeat());
        flight.add(flight04);
        Flight flight05 = new Flight("EF-99","Esfahan","Fasa",12,10 ,"1402-01-07",12 ,30);
        flight05.setOriginalSeats(flight05.getSeat());
        flight.add(flight05);
        Flight flight06 = new Flight("AB-87","Shiraz","Tehran",8,20 ,"1402-01-08",43 ,150);
        flight06.setOriginalSeats(flight06.getSeat());
        flight.add(flight06);
        Flight flight07 = new Flight("CD-52","Bandar","Lar",9, 40 ,"1402-01-09",29 ,43);
        flight07.setOriginalSeats(flight07.getSeat());
        flight.add(flight07);
        Flight flight08 = new Flight("AE-43","Yazd","Qom",7,30,"1402-01-10",64 ,72);
        flight08.setOriginalSeats(flight08.getSeat());
        flight.add(flight08);
        Flight flight09 = new Flight("AA-01","Maybod","Fasa",3,50 ,"1402-01-11",34 ,86);
        flight09.setOriginalSeats(flight09.getSeat());
        flight.add(flight09);
        Flight flight10 = new Flight("NM-12","Darab","lar",2,0 ,"1402-01-12",15 ,14);
        flight10.setOriginalSeats(flight10.getSeat());
        flight.add(flight10);

    }

}
