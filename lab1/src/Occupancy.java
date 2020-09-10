import java.util.Date;

public class Occupancy {

    private Date checkIn;
    private Date checkOut;
    private Client client;
    private Accommodation accommodation;

    public Occupancy(Date checkIn, Date checkOut, Client client, Accommodation accommodation){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.client = client;
        this.accommodation = accommodation;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
