import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengerMenu {

    public void mainPassengerMenu(String ActiveUserName, Scanner input, RandomAccessFile flightFile, RandomAccessFile userFile, RandomAccessFile ticketsFile) throws IOException {

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
                    changePassword(ActiveUserName,input,userFile);
                    choise = 0;
                    break;
                case 2:
                    searchFlightTickets (input,flightFile);
                    break;
                case 3:
                    bookingTickets (input,flightFile,ActiveUserName,ticketsFile,userFile);
                    break;
                case 4:
                    ticketCancellation (input, ActiveUserName,ticketsFile,userFile);
                    break;
                case 5:
                    bookedTickets (ActiveUserName,ticketsFile);
                    break;
                case 6:
                    addCharge (ActiveUserName,userFile,input);
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
    // Done
    private void ticketCancellation(Scanner input, String ActiveUserName, RandomAccessFile ticketsFile, RandomAccessFile userFile) throws IOException {
        for (int i = 0; i < userFile.length(); i+=38) {
            userFile.seek(i);
            if (ActiveUserName.equals(userFile.readUTF())) {
                System.out.println("pls enter the flight id that you wish to cancel: ");
                int cancelFlightId = input.nextInt();
                input.nextLine();
                for (int j = 0; j < ticketsFile.length(); j++) {
                    ticketsFile.seek(j);
                    if (ticketsFile.readInt() == cancelFlightId) {
                        ticketsFile.seek(j);
                        System.out.print(ticketsFile.readInt() + " | ");
                        System.out.print(ticketsFile.readUTF() + " | ");
                        System.out.print(ticketsFile.readUTF() + " | ");
                        System.out.print(ticketsFile.readInt() + " | ");
                        System.out.println();
                        System.out.println("""
                                do you wish to cancel it?
                                <1> Yes
                                <2> No
                                """);
                        int coise01 = input.nextInt();
                        input.nextLine();
                        if (coise01 == 1) {
                            // returning the money to user
                            userFile.seek(i + 34);
                            ticketsFile.seek(j + 38);
                            int returnedPrice = userFile.readInt() + ticketsFile.readInt();
                            userFile.seek(userFile.getFilePointer() - 4);
                            userFile.writeInt(returnedPrice);

                            // now remove the ticket
                            ticketsFile.seek(j + 42);
                            boolean check = true;
                            while (check) {
                                // read the next flight
                                if (ticketsFile.getFilePointer() != (j + 42))
                                    ticketsFile.seek(ticketsFile.getFilePointer() + 42);

                                if (ticketsFile.getFilePointer() == ticketsFile.length())
                                    check = false;

                                int subId = ticketsFile.readInt();
                                String subBoughTicketUser = ticketsFile.readUTF();
                                String subBoughtFlightId = ticketsFile.readUTF();
                                int subPrice = ticketsFile.readInt();
                                ticketsFile.seek(ticketsFile.getFilePointer() - 84);
                                ticketsFile.writeInt(subId);
                                ticketsFile.writeUTF(subBoughTicketUser);
                                ticketsFile.writeUTF(subBoughtFlightId);
                                ticketsFile.writeInt(subPrice);

                                // todo remove the last flight
                            }
                            System.out.println("Done");
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
    // Done
    private void bookedTickets(String activeUserName, RandomAccessFile ticketsFile) throws IOException {
        for (int i = 0; i < ticketsFile.length(); i++) {
        ticketsFile.seek(i + 4);
            if (ticketsFile.readUTF().equals(activeUserName)) {
                ticketsFile.seek(i);
                System.out.print(ticketsFile.readInt() + " | ");
                System.out.print(ticketsFile.readUTF() + " | ");
                System.out.print(ticketsFile.readUTF() + " | ");
                System.out.print(ticketsFile.readInt() + " | ");
                System.out.println();
            }
        }
        System.out.println();
    }
    // Done
    private void addCharge(String activeUserName, RandomAccessFile userFile, Scanner input) throws IOException {
        for (int i = 0; i < userFile.length(); i+= 38) {
            userFile.seek(i);
            if (activeUserName.equals(userFile.readUTF())) {
                userFile.seek(i + 34);
                System.out.printf("your cornet charge is: " + userFile.readInt());
                System.out.println();
                System.out.println("how mach do you want to add to your charge? ");
                System.out.println("your charge needs to be more then 0 :), its your problem if you make a mistake");
                int addPrice = input.nextInt();
                input.nextLine();
                userFile.seek(userFile.getFilePointer() - 4);
                int cornetCharge = userFile.readInt();
                userFile.seek(userFile.getFilePointer() - 4);
                userFile.writeInt(cornetCharge + addPrice);
                System.out.println("Done");
            }
        }
    }
    // Done
    private void bookingTickets(Scanner input, RandomAccessFile flightFile, String ActiveUserName, RandomAccessFile ticketsFile, RandomAccessFile userFile) throws IOException {
        for (int i = 0; i < userFile.length(); i+=38) {
            userFile.seek(i);
            ActiveUserName = fixUserName(ActiveUserName);
            if (ActiveUserName.equals(userFile.readUTF())) {
                System.out.println("pls enter the flight id that you want to buy: ");
                String buyFlight = input.nextLine();
                for (int j = 0; j < flightFile.length(); j+= 66) {
                    flightFile.seek(j);
                    if (buyFlight.equals(flightFile.readUTF())) {
                        flightFile.seek(flightFile.getFilePointer() - 8);
                        System.out.print(flightFile.readUTF() + " | ");
                        System.out.print(flightFile.readUTF() + " | ");
                        System.out.print(flightFile.readUTF() + " | ");
                        System.out.print(flightFile.readInt() + " | ");
                        System.out.print(flightFile.readInt() + " | ");
                        System.out.print(flightFile.readUTF() + " | ");
                        System.out.print(flightFile.readInt() + " | ");
                        System.out.print(flightFile.readInt() + " | ");
                        System.out.print(flightFile.readInt() + " | ");
                        System.out.println();
                        flightFile.seek(flightFile.getFilePointer() - 12);
                        System.out.println("how many seats do you want? ");
                        int buySeats = input.nextInt();
                        input.nextLine();
                        if (buySeats <= flightFile.readInt()) {
                            flightFile.seek(flightFile.getFilePointer() + 4);
                            int buyPrice = flightFile.readInt() * buySeats;
                            System.out.printf("the price will be: " + buyPrice);
                            System.out.println();
                            userFile.seek(userFile.getFilePointer() + 17);
                            System.out.printf("your charge is: " + userFile.readInt());
                            System.out.println();
                            System.out.println("do you wish to buy it? ");
                            System.out.println("""
                                    <1> Yes
                                    <2> NO
                                    """);
                            int choise = input.nextInt();
                            input.nextLine();
                            userFile.seek(userFile.getFilePointer() - 4);
                            if (choise == 1) {
                                if (buyPrice <= userFile.readInt()) {
                                    userFile.seek(userFile.getFilePointer() - 4);
                                    int afterCharge = userFile.readInt() - buyPrice;
                                    userFile.seek(userFile.getFilePointer() - 4);
                                    userFile.writeInt(afterCharge);

                                    ticketsFile.seek(ticketsFile.length());
                                    ticketsFile.writeInt(1000+i);
                                    ticketsFile.writeUTF(ActiveUserName);
                                    flightFile.seek(flightFile.getFilePointer() - 66);
                                    ticketsFile.writeUTF(flightFile.readUTF());
                                    ticketsFile.writeInt(buyPrice);
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
    // Done
    private void searchFlightTickets(Scanner input, RandomAccessFile flightFile) {
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

    private void changePassword(String ActiveUserName, Scanner input, RandomAccessFile userFile) throws IOException {
        for (int i = 0; i < userFile.length(); i+=38) {
            userFile.seek(i);
            if (ActiveUserName.equals(userFile.readUTF())) {
                System.out.println("pls enter the new password: ");
                String newPassword = input.nextLine();
                userFile.writeUTF(fixUserPassword(newPassword));
                System.out.println("Done");
            }
        }
    }
    // Done
    public String fixUserName (String PassengerName) {
        for (int i = 0; i < 15; i++) {
            if (PassengerName.length() <= 15) {
                PassengerName += " ";
            } else {
                return PassengerName.substring(0,15);
            }
        }
        return null;
    }
    // Done
    public String fixUserPassword (String PassengerPassword) {
        for (int i = 0; i < 15; i++) {
            if (PassengerPassword.length() <= 15) {
                PassengerPassword += " ";
            } else {
                return PassengerPassword.substring(0,15);
            }
        }
        return null;
    }
    // Done
}
