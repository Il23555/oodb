package hotel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.List;

@XmlRootElement(name="occupancy")
public class Occupancy {

    private Calendar checkIn;
    private Calendar checkOut;
    private Client client;
    private Accommodation accommodation;
    private List<Service> useOfServices;

    public Occupancy(){

    }

    public Occupancy(Calendar checkIn, Calendar checkOut, Client client, Accommodation accommodation, List<Service> useOfServices){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.client = client;
        this.accommodation = accommodation;
        this.useOfServices = useOfServices;
    }

    @XmlElement(name = "checkIn")
    public Calendar getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Calendar checkIn) {
        this.checkIn = checkIn;
    }

    @XmlElement(name = "checkOut")
    public Calendar getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Calendar checkOut) {
        this.checkOut = checkOut;
    }

    @XmlElement(name = "client")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @XmlElement(name = "accommodation")
    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    @XmlElementWrapper(name = "useOfServices")
    @XmlElement(name = "service")
    public List<Service> getUseOfServices() {
        return useOfServices;
    }

    public void setUseOfServices(List<Service> useOfServices) {
        this.useOfServices = useOfServices;
    }

    @Override
    public String toString() {
        return "Occupancy:" + "\n" +
                "checkIn=" + checkIn.getTime() + "\n" +
                "checkOut=" + checkOut.getTime() + "\n" +
                "client=" + client.toString() + "\n" +
                "accommodation=" + accommodation.toString() + "\n" +
                "useOfServices=" + useOfServices.toString() +
                '}';
    }
}
