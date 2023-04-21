public class Tickets {

    private int boughtTicketCode;
    private String boughTicketUser;
    private String boughtFlightId;
    private int usedPrice;

    public Tickets(int boughtTicketCode, String boughTicketUser, String boughtFlightId, int usedPrice) {
        this.boughtTicketCode = boughtTicketCode;
        this.boughTicketUser = boughTicketUser;
        this.boughtFlightId = boughtFlightId;
        this.usedPrice = usedPrice;
    }

    public int getUsedPrice() {
        return usedPrice;
    }

    public void setUsedPrice(int usedPrice) {
        this.usedPrice = usedPrice;
    }

    public int getBoughtTicketCode() {
        return boughtTicketCode;
    }

    public void setBoughtTicketCode(int boughtTicketCode) {
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
