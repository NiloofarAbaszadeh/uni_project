import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {

    public void mainAdminMenu(Scanner input,ArrayList<Flight> flight) {

        boolean choise = true;
        while (choise) {

            System.out.println();
            System.out.println("===================================================");
            System.out.println("=================== Admin menu ====================");
            System.out.println("===================================================");
            System.out.println();
            System.out.println("    <1> Add Flight");
            System.out.println("    <2> Update Flights");
            System.out.println("    <3> Remove Flights");
            System.out.println("    <4> Flight Schedule");
            System.out.println("    <0> Sign Out");
            System.out.println(" >>>>  ");
            int choiseAdminMenu = input.nextInt();
            input.nextLine();
            switch (choiseAdminMenu) {
                case 1:
                    addFlight(input,flight);
                    break;
                case 2:
                    System.out.println("Enter the flight id that you wish to change: ");
                    String flightIdSearcher01 = input.nextLine();
                    updateFlight(flightIdSearcher01,input,flight);
                    break;
                case 3:
                    System.out.println("Enter the flight id that you wish to change: ");
                    String flightIdSearcher02 = input.nextLine();
                    removeFlight(input, flight, flightIdSearcher02);
                    break;
                case 4:
                    viewFlightSchedules(flight);
                case 0:
                    choise = false;
                    break;
                default:
                    System.out.println("pls enter a valid number :)");
                    break;
            }

        }
    }
    public void addFlight (Scanner input, ArrayList<Flight> flight) {
        System.out.println("---------------------------------------");
        System.out.println("------------Add flight menu------------");
        System.out.println("---------------------------------------");
        System.out.println();
        Flight flight01 = new Flight();
        System.out.println("Enter flight Id: ");
        flight01.setFlightId(input.nextLine());
        System.out.println("Enter flight Origin: ");
        flight01.setOrigin(input.nextLine());
        System.out.println("Enter flight Destination: ");
        flight01.setDestination(input.nextLine());
        System.out.println("Enter flight time: ");
        System.out.println("hour: ");
        flight01.setHour(input.nextInt());
        input.nextLine();
        System.out.println("min: ");
        flight01.setMin(input.nextInt());
        input.nextLine();
        System.out.println("Enter flight date: ");
        flight01.setDate(input.nextLine());
        System.out.println("Enter flight seats: ");
        flight01.setMin(input.nextInt());
        input.nextLine();
        System.out.println("Enter flight price: ");
        flight01.setPrice(input.nextInt());
        input.nextLine();
        flight.add(flight01);
        // the last line needs to be tested
    }

    public void updateFlight (String flightIdSearcher, Scanner input, ArrayList<Flight> flight) {
        for (int i = 0; i < flight.size(); i++) {
            if (flightIdSearcher.equals(flight.get(i).getFlightId())) {
                System.out.println(flight);
                System.out.println("which part do you wish to change?");
                System.out.println("""
                         <1> Origin
                         <2> Destination
                         <3> Date
                         <4> Time
                         <5> Price
                         <6> Seats
                          >>>
                        """);
                int changeFilter = input.nextInt();
                input.nextLine();
                boolean loopControl = true;
                while (loopControl) {
                switch (changeFilter) {
                    case 1:
                        System.out.printf("old origin: " + flight.get(i).getOrigin());
                        System.out.println("pls enter the new Origin:");
                        flight.get(i).setOrigin(input.nextLine());
                        loopControl = false;
                        break;
                    case 2:
                        System.out.printf("old Destination: " + flight.get(i).getDestination());
                        System.out.println("pls enter the new Destination:");
                        flight.get(i).setDestination(input.nextLine());
                        loopControl = false;
                        break;
                    case 3:
                        System.out.printf("old Date:" + flight.get(i).getDate());
                        System.out.println("pls enter the new Date:");
                        flight.get(i).setDate(input.nextLine());
                        loopControl = false;
                        break;
                    case 4:
                        System.out.println("old time: ");
                        System.out.printf("hour: " + flight.get(i).getHour());
                        System.out.printf("min: " + flight.get(i).getMin());
                        System.out.println("pls enter the new time:");
                        int newHour = input.nextInt();
                        input.nextLine();
                        flight.get(i).setHour(newHour);
                        int newMin = input.nextInt();
                        input.nextLine();
                        flight.get(i).setMin(newMin);
                        loopControl = false;
                        break;
                    case 5:
                        System.out.printf("old price: " + flight.get(i).getPrice());
                        System.out.println("pls enter the new Origin:");
                        flight.get(i).setPrice(input.nextDouble());
                        loopControl = false;
                        break;
                    case 6:
                        System.out.printf("old seats: " + flight.get(i).getSeat());
                        System.out.println("pls enter the new Seats:");
                        int newSeats = input.nextInt();
                        input.nextLine();
                        flight.get(i).setSeat(newSeats);
                        final int SEAT_ORIGINAL = newSeats;
                        loopControl = false;
                        break;
                    default:
                        System.out.println("pls enter a valid number");
                    }
                }
                break;
            } else if (flight.size() == i) {
                System.out.println("Flight not found");
            } else {
                // nothing
            }

        }
    }
    public void removeFlight (Scanner input, ArrayList<Flight> flight, String flightIdSearcher02) {
        for (int i = 0; i < flight.size(); i++) {
            if (flightIdSearcher02.equals(flight.get(i).getFlightId())) {
                flight.remove(i);
                System.out.println("the flight has ben successfully removed");
            } else if (flight.size() == i) {
                System.out.println("Flight not found");
            } else {
                // nothing
            }
        }
    }
    public void viewFlightSchedules (ArrayList<Flight> flight) {
        for (int i = 0; i < flight.size(); i++) {
            System.out.println(flight);
        }
    }
}
