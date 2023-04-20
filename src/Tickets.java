public class Tickets {

    private String boughtTicketCode;
    private String boughTicketUser;
    private String boughtFlightId;

    public Tickets(String boughtTicketCode, String boughTicketUser, String boughtFlightId) {
        this.boughtTicketCode = boughtTicketCode;
        this.boughTicketUser = boughTicketUser;
        this.boughtFlightId = boughtFlightId;
    }

    public String getBoughtTicketCode() {
        return boughtTicketCode;
    }

    public void setBoughtTicketCode(String boughtTicketCode) {
        this.boughtTicketCode = boughtTicketCode;
    }

    public String getBoughTicketUser() {
        return boughTicketUser;
    }

    public void setBoughTicketUser(String boughTicketUser) {
        this.boughTicketUser = boughTicketUser;
    }

    public String getBoughtFlightId() {
        return boughtFlightId;
    }

    public void setBoughtFlightId(String boughtFlightId) {
        this.boughtFlightId = boughtFlightId;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "boughtTicketCode='" + boughtTicketCode + '\'' +
                ", boughTicketUser='" + boughTicketUser + '\'' +
                ", boughtFlightId='" + boughtFlightId + '\'' +
                '}';
    }
}
