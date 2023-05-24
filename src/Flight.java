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
    private int price;

    public Flight(String flightId, String origin, String destination, int hour, int min, String date, int seat, int price) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.hour = hour;
        this.min = min;
        this.date = date;
        this.seat = seat;
        this.originalSeats = seat;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addFlightToFile (String flightId, String origin, String destination, int hour, int min, String date, int seat, int price) {
        // todo : write on Flight file

    }
    public String fixFlightId () {

        for (int i = 0; i < 6; i++) {
            if (flightId.length() <= 6) {
                flightId += " ";
            } else {
                return flightId;
            }
        }
        return null;
    }
    public String fixOrigin () {

        for (int i = 0; i < 10; i++) {
            if (origin.length() <= 10) {
                origin += " ";
            } else {
                return origin;
            }
        }
        return null;
    }
    public String fixDestination () {

        for (int i = 0; i < 10; i++) {
            if (destination.length() <= 10) {
                destination += " ";
            } else {
                return destination;
            }
        }
        return null;
    }
    public String fixTime () {
        String time = hour + " : " + min;
        for (int i = 0; i < 8; i++) {
            if (time.length() <= 8) {
                time += " ";
            } else {
                return time;
            }
        }
        return null;
    }
    public String fixDate () {
        for (int i = 0; i < 12; i++) {
            if (date.length() <= 12) {
                date += " ";
            } else {
                return date;
            }
        }
        return null;
    }
    public String fixSeat () {
        String stringSeat = String.valueOf(seat);
        for (int i = 0; i < 6; i++) {
            if (stringSeat.length() <= 6) {
                stringSeat += " ";
            } else {
                return stringSeat;
            }
        }
        return null;
    }
    public String fixPrice () {
        String stringPrice = String.valueOf(price);
        for (int i = 0; i < 15; i++) {
            if (stringPrice.length() <= 15) {
                stringPrice += " ";
            } else {
                return stringPrice;
            }
        }
        return null;
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
