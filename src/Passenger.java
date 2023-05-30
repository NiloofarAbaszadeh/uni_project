import java.io.IOException;

public class Passenger {

    protected String PassengerName;
    protected String PassengerPassword;
    protected int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

    public String fixUserName () {
        for (int i = 0; i < 15; i++) {
            if (PassengerName.length() <= 15) {
                PassengerName += " ";
            } else {
                return PassengerName.substring(0,15);
            }
        }
        return null;
    }

    public String fixUserPassword () {
        for (int i = 0; i < 15; i++) {
            if (PassengerPassword.length() <= 15) {
                PassengerPassword += " ";
            } else {
                return PassengerPassword.substring(0,15);
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "PassengerName='" + PassengerName + '\'' +
                ", PassengerPassword='" + PassengerPassword + '\'' +
                '}';
    }
}
