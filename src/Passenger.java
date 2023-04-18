public class Passenger {

    private String PassengerName;
    private String Password;

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "PassengerName='" + PassengerName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
