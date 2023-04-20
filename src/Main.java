import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Flight> flight = new ArrayList();
        ArrayList<Passenger> passengers = new ArrayList();
        ArrayList<Tickets> tickets = new ArrayList();
        Scanner input = new Scanner(System.in);
        StartMenu startMenu = new StartMenu();

        startMenu.addFirstTenFlights (flight);
        startMenu.menu(input,flight,passengers);


    }
}