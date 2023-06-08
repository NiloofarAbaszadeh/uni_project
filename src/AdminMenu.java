import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AdminMenu {
    public void mainAdminMenu(Scanner input, RandomAccessFile flightFile) throws IOException {

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
                    updateFlight(flightIdSearcher01,input,flightFile);
                    break;
                case 3:
                    System.out.println("Enter the flight id that you wish to change: ");
                    String flightIdSearcher02 = input.nextLine();
                    removeFlight(flightIdSearcher02, flightFile);
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
    public void updateFlight (String flightIdSearcher, Scanner input, RandomAccessFile flightFile) throws IOException {
        for (int i = 0; i < flightFile.length(); i+=66) {
            flightFile.seek(i);
            if (flightIdSearcher.equals(flightFile.readUTF())) {
                flightFile.seek(i + 54);
                if (flightFile.readInt() != flightFile.readInt()) {
                    System.out.println("you can`t update this flight because some one has already reserved it");
                    break;
                }
                // printing the flight
                flightFile.seek(i);
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
                // printing flight info
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
                        System.out.println("pls enter the new Origin:");
                        flightFile.seek(i + 8);
                        flightFile.writeUTF(fixOrigin(input.nextLine()));
                        loopControl = false;
                        break;
                    case 2:
                        System.out.println("pls enter the new Destination:");
                        flightFile.seek(i + 20);
                        flightFile.writeUTF(fixDestination(input.nextLine()));
                        loopControl = false;
                        break;
                    case 3:
                        System.out.println("pls enter the new Date (Sample: 1402/01/12): ");
                        flightFile.seek(i + 40);
                        flightFile.writeUTF(fixDate(input.nextLine()));
                        loopControl = false;
                        break;
                    case 4:
                        System.out.println("pls enter the new time:");
                        System.out.println("Hour: ");
                        flightFile.seek(i + 32);
                        flightFile.writeInt(input.nextInt());
                        input.nextLine();

                        System.out.println("Min: ");
                        flightFile.writeInt(input.nextInt());
                        input.nextLine();
                        loopControl = false;
                        break;
                    case 5:
                        System.out.println("pls enter the new Price:");
                        flightFile.seek(i + 62);
                        flightFile.writeInt(input.nextInt());
                        input.nextLine();
                        loopControl = false;
                        break;
                    case 6:
                        System.out.println("pls enter the new Seats:");
                        int newSeats = input.nextInt();
                        input.nextLine();
                        flightFile.seek(i + 54);
                        flightFile.writeInt(newSeats);
                        flightFile.writeInt(newSeats);
                        loopControl = false;
                        break;
                    default:
                        System.out.println("pls enter a valid number");
                    }
                }
                break;
            } else if (flightFile.length() == i) {
                System.out.println("Flight not found");
            } else {
                System.out.println("Something`s not right :)");
            }

        }
    }
    public void removeFlight (String flightIdSearcher, RandomAccessFile flightFile) throws IOException {
        for (int i = 0; i < flightFile.length(); i+=66) {
            flightFile.seek(i);
            if (flightIdSearcher.equals(flightFile.readUTF())) {
                flightFile.seek(i + 54);
                if (flightFile.readInt() != flightFile.readInt()) {
                    System.out.println("you can`t update this flight because some one has already reserved it");
                    break;
                }

                // how to delete a flight
                flightFile.seek(i + 66);
                boolean check = true;
                while (check) {
                    // read the next flight
                    if (flightFile.getFilePointer() != (i+66))
                        flightFile.seek(flightFile.getFilePointer() + 66);

                    if (flightFile.getFilePointer() == flightFile.length())
                        check = false;

                    String subFlightId = flightFile.readUTF();
                    String subOrigin = flightFile.readUTF();
                    String subDestination = flightFile.readUTF();
                    int subHour = flightFile.readInt();
                    int subMin = flightFile.readInt();
                    String subDate = flightFile.readUTF();
                    int subSeat = flightFile.readInt();
                    int subOriginalSeat = flightFile.readInt();
                    int subPrice = flightFile.readInt();
                    // write on the last flight
                    flightFile.seek(flightFile.getFilePointer() - 132);
                    flightFile.writeUTF(subFlightId);
                    flightFile.writeUTF(subOrigin);
                    flightFile.writeUTF(subDestination);
                    flightFile.writeInt(subHour);
                    flightFile.writeInt(subMin);
                    flightFile.writeUTF(subDate);
                    flightFile.writeInt(subSeat);
                    flightFile.writeInt(subOriginalSeat);
                    flightFile.writeInt(subPrice);
                }
                // todo remove the last flight on the list (ask sage)

                System.out.println("the flight has ben successfully removed");
            } else if (flightFile.length() == i) {
                System.out.println("Flight not found");
            } else {
                System.out.println("Something in not right :)");
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
    public String fixOrigin (String origin) {

        for (int i = 0; i < 10; i++) {
            if (origin.length() <= 10) {
                origin += " ";
            } else {
                return origin.substring(0,10);
            }
        }
        return null;
    }
    public String fixDestination (String destination) {

        for (int i = 0; i < 10; i++) {
            if (destination.length() <= 10) {
                destination += " ";
            } else {
                return destination.substring(0,10);
            }
        }
        return null;
    }
    public String fixDate (String date) {
        for (int i = 0; i < 12; i++) {
            if (date.length() <= 12) {
                date += " ";
            } else {
                return date.substring(0,12);
            }
        }
        return null;
    }
}
