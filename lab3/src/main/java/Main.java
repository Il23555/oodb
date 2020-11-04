import hotel.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Иванов", "Иван", "8014977688", "89397443570");
        Accommodation accommodation = new Accommodation(1, 2500, "Люкс");
        Service service = new Service("Бассейн", 500);
        List<Service> services = new ArrayList<Service>();
        services.add(service);
        Calendar checkIn = new GregorianCalendar(2020, Calendar.SEPTEMBER , 25);
        Calendar checkOut = new GregorianCalendar(2017, Calendar.SEPTEMBER , 28);

        Occupancy occupancy = new Occupancy(checkIn, checkOut, client, accommodation, services);

        XMLService.saveOccupancyData(occupancy);

        Occupancy occupancy1 = XMLService.loadOccupancyFromXML();
        System.out.println(occupancy1.toString());
    }
}
