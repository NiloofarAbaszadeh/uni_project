import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        RandomAccessFile flightFile = new RandomAccessFile("FlightInfo.dat", "rw");
        // 66 length
        RandomAccessFile userFile = new RandomAccessFile("UserInfo.dat", "rw");
        // 38 length
        RandomAccessFile ticketsFile = new RandomAccessFile("TicketInfo.dat", "rw");
        // 42

        Scanner input = new Scanner(System.in);
        StartMenu startMenu = new StartMenu();
        startMenu.addFirstTenFlights (flightFile);
        startMenu.menu(input,userFile,ticketsFile,flightFile);

    }
}