import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengerMenu {

    public void mainPassengerMenu(String ActiveUserName, Scanner input, RandomAccessFile flightFile, RandomAccessFile userFile, RandomAccessFile ticketsFile) {

        int choise = 1;
        while (choise != 0) {

            System.out.println("---------------------------------------");
            System.out.println("-------------Passenger menu------------");
            System.out.println("---------------------------------------");
            System.out.println("""

                    <1> Change Password
                    <2> Search flight ticket
                    <3> Booking ticket
                    <4> Ticket cancellation
                    <5> Booked tickets
                    <6> Add charge
                    <0> Sign out

                    """);

            choise = input.nextInt();
            input.nextLine();

            switch (choise) {
                case 1:
                    changePassword(ActiveUserName, input, passengers);
                    choise = 0;
                    break;
                case 2:
                    searchFlightTickets (input, flight);
                    break;
                case 3:
                    bookingTickets (input, flight, ActiveUserName, tickets, passengers);
                    break;
                case 4:
                    ticketCancellation (input, ActiveUserName,tickets,passengers);
                    break;
                case 5:
                    bookedTickets (ActiveUserName, tickets);
                    break;
                case 6:
                    addCharge (ActiveUserName, passengers, input);
                    break;
                case 0:
                    choise = 0;
                    break;
                default:
                    System.out.println("pls enter a valid number");
                    break;
            }


        }
    }

    private void ticketCancellation(Scanner input, String ActiveUserName, ArrayList<Tickets> tickets, ArrayList<Passenger> passengers) {
        for (int i = 0; i < passengers.size(); i++) {
            if (ActiveUserName.equals(passengers.get(i).getPassengerName())) {
                System.out.println("pls enter the flight id that you wish to cancel: ");
                String cancelFlightId = input.nextLine();
                for (int j = 0; j < tickets.size(); j++) {
                    if (tickets.get(i).getBoughtFlightId().equals(cancelFlightId)) {
                        System.out.println(tickets);
                        System.out.println("""
                                do you wish to cancel it?
                                <1> Yes
                                <2> No
                                """);
                        int coise01 = input.nextInt();
                        input.nextLine();
                        if (coise01 == 1) {
                            passengers.get(i).setPrice(tickets.get(j).getUsedPrice() + passengers.get(i).getPrice());
                            tickets.remove(i);
                            System.out.println("Done");
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    private void bookedTickets(String activeUserName, ArrayList<Tickets> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getBoughTicketUser().equals(activeUserName)) {
                System.out.println(tickets);
            }
        }
        System.out.println();
    }

    private void addCharge(String activeUserName, ArrayList<Passenger> passengers, Scanner input) {
        for (int i = 0; i < passengers.size(); i++) {
            if (activeUserName.equals(passengers.get(i).getPassengerName())) {
                System.out.printf("your cornet charge is: " + passengers.get(i).getPrice());
                System.out.println();
                System.out.println("how mach do you want to add to your charge? ");
                System.out.println("your charge needs to be more then 0 :), its your problem if you make a mistake");
                int addPrice = input.nextInt();
                input.nextLine();
                int cornetCharge = passengers.get(i).getPrice();
                passengers.get(i).setPrice(cornetCharge + addPrice);
                System.out.println("Done");

            }
        }
    }

    private void bookingTickets(Scanner input, ArrayList<Flight> flight, String ActiveUserName, ArrayList<Tickets> tickets, ArrayList<Passenger> passengers) {
        for (int i = 0; i < passengers.size(); i++) {
            if (ActiveUserName.equals(passengers.get(i).getPassengerName())) {
                System.out.println("pls enter the flight id that you want to buy: ");
                String buyFlight = input.nextLine();
                for (int j = 0; j < flight.size(); j++) {
                    if (flight.get(j).getFlightId().equals(buyFlight)) {
                        System.out.println(flight.get(j));
                        System.out.println("how many seats do you want? ");
                        int buySeats = input.nextInt();
                        input.nextLine();
                        if (buySeats <= flight.get(j).getSeat()) {
                            int buyPrice = flight.get(j).getPrice() * buySeats;
                            System.out.printf("the price will be: " + buyPrice);
                            System.out.println();
                            System.out.printf("your charge is: " + passengers.get(j).getPrice());
                            System.out.println();
                            System.out.println("do you wish to buy it? ");
                            System.out.println("""
                                    <1> Yes
                                    <2> NO
                                    """);
                            int choise = input.nextInt();
                            input.nextLine();
                            if (choise == 1) {
                                if (buyPrice <= flight.get(j).getPrice()) {
                                    int afterCharge = passengers.get(i).getPrice() - buyPrice;
                                    flight.get(j).setPrice(afterCharge);
                                    Tickets tickets1 = new Tickets(1000+i,ActiveUserName,flight.get(j).getFlightId(),buyPrice);
                                    tickets.add(tickets1);
                                    System.out.println("Done");
                                } else {
                                    System.out.println("your charge is not enough :(");
                                    break;
                                }

                            } else {
                                break;
                            }


                        }
                    }
                }
            }
        }
    }

    private void searchFlightTickets(Scanner input, ArrayList<Flight> flight) {
        boolean loopController = true;
        ArrayList <Flight> tempFlight = new ArrayList<>();
        for (int i = 0; i < flight.size(); i++) {
            tempFlight.add(flight.get(i));
        }
        while (loopController) {
            System.out.println("""
                    what are you looking for ?
                    <1> flight id
                    <2> Origin
                    <3> Destination
                    <4> Date
                    <5> Time
                    <6> Price
                    <0> Done with the search

                    """);
            int filterSearch = input.nextInt();
            input.nextLine();
            switch (filterSearch) {
                case 1:
                System.out.println("pls enter the flight id you want to search for: ");
                String SearchFlightId = input.nextLine();
                for (int i = 0; i < tempFlight.size(); i++) {
                    if (!tempFlight.get(i).getFlightId().equals(SearchFlightId)) {
                        tempFlight.remove(i);
                        i--;
                    }
                }
                    for (int i = 0; i < tempFlight.size(); i++) {
                        System.out.println(tempFlight.get(i));
                    }
                    System.out.println();
                break;
                case 2:
                    System.out.println("pls enter the Origin you want to search for: ");
                    String SearchOrigin = input.nextLine();
                    for (int i = 0; i < tempFlight.size(); i++) {
                        if (!tempFlight.get(i).getOrigin().equals(SearchOrigin)) {
                            tempFlight.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < tempFlight.size(); i++) {
                        System.out.println(tempFlight.get(i));
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("pls enter the Destination you want to search for: ");
                    String SearchDestination = input.nextLine();
                    for (int i = 0; i < tempFlight.size(); i++) {
                        if (!tempFlight.get(i).getDestination().equals(SearchDestination)) {
                            tempFlight.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < tempFlight.size(); i++) {
                        System.out.println(tempFlight.get(i));
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("pls enter the Date you want to search for: ");
                    String SearchDate = input.nextLine();
                    for (int i = 0; i < tempFlight.size(); i++) {
                        if (!tempFlight.get(i).getDate().equals(SearchDate)) {
                            tempFlight.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < tempFlight.size(); i++) {
                        System.out.println(tempFlight.get(i));
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("pls enter the Hour you want to search for: ");
                    int SearchHour = input.nextInt();
                    input.nextLine();
                    System.out.println("pls enter the Min you want to search for: ");
                    int SearchMin = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < flight.size(); i++) {
                        if (tempFlight.get(i).getHour() != SearchHour || tempFlight.get(i).getMin() != SearchMin) {
                            tempFlight.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < tempFlight.size(); i++) {
                        System.out.println(tempFlight.get(i));
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("pls enter the price you want to search for: ");
                    System.out.println("Min: ");
                    int SearchPriceMin = input.nextInt();
                    input.nextLine();
                    System.out.println("Max: ");
                    int SearchPriceMax = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < flight.size(); i++) {
                        if (SearchPriceMin < tempFlight.get(i).getPrice() || SearchPriceMax > tempFlight.get(i).getPrice()) {
                            tempFlight.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < tempFlight.size(); i++) {
                        System.out.println(tempFlight.get(i));
                    }
                    System.out.println();
                    break;
                case 0:
                    loopController = false;
                    break;
                default:
                    System.out.println("pls enter a valid number");
                    break;

            }
        }
    }

    private void changePassword(String ActiveUserName, Scanner input, ArrayList<Passenger> passengers) {
        for (int i = 0; i < passengers.size(); i++) {
            if (ActiveUserName.equals(passengers.get(i).getPassengerName())) {
                System.out.println("pls enter the new password: ");
                String newPassword = input.nextLine();
                passengers.get(i).setPassengerPassword(newPassword);
                System.out.println("Done");
                System.out.println();
            }
        }
    }
}
