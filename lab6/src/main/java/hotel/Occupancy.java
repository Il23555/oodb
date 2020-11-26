package hotel;

import annotations.Column;
import annotations.Entity;
import annotations.OneToMany;
import annotations.OneToOne;

import java.util.Date;

@Entity
public class Occupancy {

    @Column
    private Date checkIn;
    @Column
    private Date checkOut;
    @Column
    private Client client;
    @Column
    @OneToOne
    private Accommodation accommodation;
    @Column
    @OneToOne
    private UseOfServices useOfServices;

    public Occupancy(Date checkIn, Date checkOut, Client client, Accommodation accommodation, UseOfServices useOfServices){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.client = client;
        this.accommodation = accommodation;
        this.useOfServices = useOfServices;
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

    public UseOfServices getUseOfServices() {
        return useOfServices;
    }

    public void setUseOfServices(UseOfServices useOfServices) {
        this.useOfServices = useOfServices;
    }
}
