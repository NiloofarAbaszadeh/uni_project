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

    public String fixBoughtTicketCode () {
        String stringBoughtTicketCode = String.valueOf(boughtTicketCode);
        for (int i = 0; i < 6; i++) {
            if (stringBoughtTicketCode.length() <= 6) {
                stringBoughtTicketCode += " ";
            } else {
                return stringBoughtTicketCode;
            }
        }
        return null;
    }

    public String fixBoughTicketUser () {
        for (int i = 0; i < 15; i++) {
            if (boughTicketUser.length() <= 6) {
                boughTicketUser += " ";
            } else {
                return boughTicketUser;
            }
        }
        return null;
    }

    public String fixBoughtFlightId () {
        for (int i = 0; i < 15; i++) {
            if (boughtFlightId.length() <= 6) {
                boughtFlightId += " ";
            } else {
                return boughtFlightId;
            }
        }
        return null;
    }

    public String fixUsedPrice () {
        String stringUsedPrice = String.valueOf(usedPrice);
        for (int i = 0; i < 15; i++) {
            if (stringUsedPrice.length() <= 15) {
                stringUsedPrice += " ";
            } else {
                return stringUsedPrice;
            }
        }
        return null;
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
