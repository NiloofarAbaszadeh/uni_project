import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Flight> flight = new ArrayList();
        ArrayList<Passenger> passengers = new ArrayList();
        ArrayList<Tickets> tickets = new ArrayList();
//        RandomAccessFile flights = new RandomAccessFile("flights.txt","rw");
//
//        RandomAccessFile ticket = new RandomAccessFile("ticket.txt","rw");
        RandomAccessFile flightFile = new RandomAccessFile("FlightInfo.data", "rw");
        RandomAccessFile userInfo = new RandomAccessFile("UserInfo.data", "rw");
        RandomAccessFile ticketsInfo = new RandomAccessFile("TicketInfo.data", "rw");
        Scanner input = new Scanner(System.in);
        StartMenu startMenu = new StartMenu();

        startMenu.addFirstTenFlights (flight);
        startMenu.menu(input,flight,passengers,tickets);


    }
}