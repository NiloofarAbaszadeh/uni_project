public class Flight {

    private String flightId;
    private String origin;
    private String destination;
    // time
    private int hour;
    private int min;
    private String date;
    private int seat;
    private int originalSeats;
    private double price;

    public Flight(String flightId, String origin, String destination, int hour, int min, String date, int seat, double price) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.hour = hour;
        this.min = min;
        this.date = date;
        this.seat = seat;
        this.price = price;
    }

    public int getOriginalSeats() {
        return originalSeats;
    }

    public void setOriginalSeats(int originalSeats) {
        this.originalSeats = originalSeats;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", hour=" + hour +
                ", min=" + min +
                ", date='" + date + '\'' +
                ", seat=" + seat +
                ", price=" + price +
                '}';
    }
}
