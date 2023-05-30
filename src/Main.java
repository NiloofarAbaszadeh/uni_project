import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Flight> flight = new ArrayList();
        ArrayList<Passenger> passengers = new ArrayList();
        ArrayList<Tickets> tickets = new ArrayList();

        RandomAccessFile flightFile = new RandomAccessFile("FlightInfo.dat", "rw");
        // 66 length
        RandomAccessFile userFile = new RandomAccessFile("UserInfo.dat", "rw");
        //
        RandomAccessFile ticketsFile = new RandomAccessFile("TicketInfo.dat", "rw");
        //

        Scanner input = new Scanner(System.in);
        StartMenu startMenu = new StartMenu();
        startMenu.addFirstTenFlights (flightFile);
        startMenu.menu(input,flight,passengers,tickets,flightFile);

    }
}