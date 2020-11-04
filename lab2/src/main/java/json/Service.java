package json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import hotel.Client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Service {

    public static List<Client> sortClientsByLastName(List<Client> clients) throws IOException, JsonSyntaxException {
        Collections.sort(clients,  new Comparator<Client>() {
            public int compare(Client cl1, Client cl2) {
                return cl1.getLastName().compareTo(cl2.getLastName());
            }
        });

        return clients;
    }

    public static Client findPersonByLastName(List<Client> clients, String searchName) {
        Client result = null;
        for (Client client : clients) {
            if (client.getLastName().equals(searchName)) {
                result = client;
            }
        }

        return result;
    }

}
