import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {

    public void mainAdminMenu(Scanner input,ArrayList<Flight> flight, RandomAccessFile flightFile) throws IOException {

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
                    addFlight(input,flightFile);
                    break;
                case 2:
                    System.out.println("Enter the flight id that you wish to change: ");
                    String flightIdSearcher01 = input.nextLine();
                    updateFlight(flightIdSearcher01,input,flight);
                    break;
                case 3:
                    System.out.println("Enter the flight id that you wish to change: ");
                    String flightIdSearcher02 = input.nextLine();
                    removeFlight(flight, flightIdSearcher02);
                    break;
                case 4:
                    viewFlightSchedules(flightFile);
                    break;
                case 0:
                    choise = false;
                    break;
                default:
                    System.out.println("pls enter a valid number :)");
                    break;
            }

        }
    }
    public void addFlight (Scanner input, RandomAccessFile flightFile) throws IOException {
        System.out.println("---------------------------------------");
        System.out.println("------------Add flight menu------------");
        System.out.println("---------------------------------------");
        System.out.println();

        System.out.println("Enter flight Id: ");
        String flightId = input.nextLine();

        System.out.println("Enter flight Origin: ");
        String Origin = input.nextLine();

        System.out.println("Enter flight Destination: ");
        String Destination = input.nextLine();

        System.out.println("Enter flight time: ");
        System.out.println("hour: ");
        int Hour = input.nextInt();
        input.nextLine();
        System.out.println("min: ");
        int Min = input.nextInt();

        input.nextLine();
        System.out.println("Enter flight date: ");

        String Date = input.nextLine();
        System.out.println("Enter flight seats: ");
        int Seat = input.nextInt();

        input.nextLine();
        System.out.println("Enter flight price: ");
        int Price = input.nextInt();
        input.nextLine();

        Flight flight01 = new Flight(flightId,Origin,Destination,Hour,Min,Date,Seat,Price);
        writeFlightsOnFile(flightFile, flight01);
    }
    public void updateFlight (String flightIdSearcher, Scanner input, ArrayList<Flight> flight) {
        for (int i = 0; i < flight.size(); i++) {
            if (flightIdSearcher.equals(flight.get(i).getFlightId())) {
                if (flight.get(i).getSeat() != flight.get(i).getOriginalSeats()) {
                    System.out.println("you can`t update this flight because some one has already reserved it");
                    break;
                }
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
                        System.out.println();
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
                        System.out.println("pls enter the new Date (Sample: 1402/01/12): ");
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
                        flight.get(i).setPrice(input.nextInt());
                        loopControl = false;
                        break;
                    case 6:
                        System.out.printf("old seats: " + flight.get(i).getSeat());
                        System.out.println("pls enter the new Seats:");
                        int newSeats = input.nextInt();
                        input.nextLine();
                        flight.get(i).setSeat(newSeats);
                        flight.get(i).setOriginalSeats(newSeats);
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
    public void removeFlight (ArrayList<Flight> flight, String flightIdSearcher02) {
        for (int i = 0; i < flight.size(); i++) {
            if (flightIdSearcher02.equals(flight.get(i).getFlightId())) {
                if (flight.get(i).getSeat() != flight.get(i).getOriginalSeats()) {
                    System.out.println("you can`t remove this flight because some one has already reserved it");
                    break;
                }
                flight.remove(i);
                System.out.println("the flight has ben successfully removed");
            } else if (flight.size() == i) {
                System.out.println("Flight not found");
            } else {
                // nothing
            }
        }
    }
    public void viewFlightSchedules (RandomAccessFile flightFile) throws IOException {
        flightFile.seek(0);
        while (flightFile.length() != flightFile.getFilePointer()) {
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
        }

    }
    public void writeFlightsOnFile (RandomAccessFile flightFile, Flight flight) throws IOException {
        flightFile.seek(flightFile.length());
        flightFile.writeUTF(flight.fixFlightId());
        flightFile.writeUTF(flight.fixOrigin());
        flightFile.writeUTF(flight.fixDestination());
        flightFile.writeInt(flight.getHour());
        flightFile.writeInt(flight.getMin());
        flightFile.writeUTF(flight.fixDate());
        flightFile.writeInt(flight.getSeat());
        flightFile.writeInt(flight.getOriginalSeats());
        flightFile.writeInt(flight.getPrice());

    }
}
