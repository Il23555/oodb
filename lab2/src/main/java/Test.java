import hotel.Client;
import json.Load;
import json.Save;
import json.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        Client client = new Client("Иван", "Иванов", "8011956697", "89063478900");
        Client client1 = new Client("Александр", "Александров", " 8011967772", "89603478600");

        Client client2 = new Client("Арина", "Емельянова", "8010978687", "89103578950");
        Client client3 = new Client("Диана", "Алексеева", " 8014974688", "89134478625");

        Client client4 = new Client("Наиль", "Шайдуллин", "8012970897", "89504478900");
        Client client5 = new Client("Марат", "Исмагилов", " 80139788698", "86243478620");

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(client);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);

        Save.saveClientList(clients);

        List<Client> resClients = Load.loadClientList();
        System.out.println();
        List<Client> orderClients = Service.sortClientsByLastName(resClients);
        for (Client cl:orderClients) {
            System.out.println(cl.toString());
        }
        System.out.println();

        Client client_search = Service.findPersonByLastName(resClients,"Иванов");
        System.out.println(client_search.toString());
    }
}
