import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class StartMenu {

    public void menu (Scanner input, RandomAccessFile userFile, RandomAccessFile ticketsFile, RandomAccessFile flightFile) throws IOException {
        while (true) {
            int ChoseMenu = 0;
            printMainMenu();
            ChoseMenu = input.nextInt();
            input.nextLine();

            if (ChoseMenu == 1) {
                // Sign in menu
                String ActiveUserName = null;
                boolean checkUserName = true;
                while (checkUserName) {
                    int check = 1;
                    System.out.println("Enter user name");
                    System.out.print(">>>> ");
                    ActiveUserName = input.nextLine();
                    // admin login menu
                    if (ActiveUserName.equals("Admin")) {
                        System.out.println("Enter user Password");
                        System.out.print(">>>>");
                        String ActiveUserPassword = input.nextLine();
                        if(ActiveUserPassword.equals("admin")) {
                            AdminMenu adminMenu = new AdminMenu();
                            adminMenu.mainAdminMenu(input,flightFile);
                            checkUserName = false;
                        } else {
                            System.out.println("not the right password");
                        }
                    }
                    // normal user login
                    ActiveUserName = fixUserName(ActiveUserName);
                    for (int i = 0; i < userFile.length(); i+=38) {
                        userFile.seek(i);
                        if (ActiveUserName.equals(userFile.readUTF())) {
                            // test
                            System.out.println("Enter user Password");
                            System.out.print(">>>> ");
                            String ActiveUserPassword = fixUserPassword(input.nextLine());
                            if (ActiveUserPassword.equals(userFile.readUTF())) {
                                PassengerMenu passengerMenu = new PassengerMenu();
                                passengerMenu.mainPassengerMenu(ActiveUserName,input,flightFile,userFile,ticketsFile);

                            } else {
                                System.out.println("not the right password");
                            }
                            checkUserName = false;
                            break;
                        }
                        if (userFile.getFilePointer()+21 == userFile.length() && checkUserName) {
                            System.out.println("""
                                    This user does no exist, you can quite this part or try again.
                                    <1> try again
                                    <2> quite
                                    """ );
                            check = input.nextInt();
                            input.nextLine();
                            if (check == 2)
                                checkUserName = false;
                            break;
                        }
                    }
                    if (check == 2)
                        break;
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
                userFile.seek(userFile.length());
                userFile.writeUTF(passengers01.fixUserName());
                userFile.writeUTF(passengers01.fixUserPassword());
                userFile.writeInt(0);
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
    public void addFirstTenFlights (RandomAccessFile flightFile) throws IOException {
        if (flightFile.length() == 0) {
            Flight flight01 = new Flight("WX-09", "Tehran", "Qazvin", 1, 45, "1402-01-03", 45, 95);
            writeFlightsOnFile(flightFile, flight01);
            Flight flight02 = new Flight("YZ-32", "Ardakan", "Rasht", 13, 15, "1402-01-04", 31, 90);
            writeFlightsOnFile(flightFile, flight02);
            Flight flight03 = new Flight("XH-11", "AliAbad", "Shiraz", 21, 5, "1402-01-05", 14, 140);
            writeFlightsOnFile(flightFile, flight03);
            Flight flight04 = new Flight("MA-10", "Mashhad", "Abadeh", 4, 25, "1402-01-06", 110, 400);
            writeFlightsOnFile(flightFile, flight04);
            Flight flight05 = new Flight("EF-99", "Esfahan", "Fasa", 12, 10, "1402-01-07", 12, 30);
            writeFlightsOnFile(flightFile, flight05);
            Flight flight06 = new Flight("AB-87", "Shiraz", "Tehran", 8, 20, "1402-01-08", 43, 150);
            writeFlightsOnFile(flightFile, flight06);
            Flight flight07 = new Flight("CD-52", "Bandar", "Lar", 9, 40, "1402-01-09", 29, 43);
            writeFlightsOnFile(flightFile, flight07);
            Flight flight08 = new Flight("AE-43", "Yazd", "Qom", 7, 30, "1402-01-10", 64, 72);
            writeFlightsOnFile(flightFile, flight08);
            Flight flight09 = new Flight("AA-01", "Maybod", "Fasa", 3, 50, "1402-01-11", 34, 86);
            writeFlightsOnFile(flightFile, flight09);
            Flight flight10 = new Flight("NM-12", "Darab", "lar", 2, 0, "1402-01-12", 15, 14);
            writeFlightsOnFile(flightFile, flight10);
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
}
