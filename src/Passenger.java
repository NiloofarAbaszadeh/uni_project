public class Passenger {

    private String PassengerName;
    private String PassengerPassword;

    public Passenger(String passengerName, String passengerPassword) {
        PassengerName = passengerName;
        PassengerPassword = passengerPassword;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public String getPassengerPassword() {
        return PassengerPassword;
    }

    public void setPassengerPassword(String passengerPassword) {
        PassengerPassword = passengerPassword;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "PassengerName='" + PassengerName + '\'' +
                ", PassengerPassword='" + PassengerPassword + '\'' +
                '}';
    }
}
