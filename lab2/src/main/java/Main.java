import hotel.Client;
import json.Load;
import json.Service;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/hotel";
            Connection connection = DriverManager.getConnection(dbURL, "postgres", "7reu52dy");

            List<Client> clients_from_file = Load.loadClientList();
            System.out.println("JSON file:\n");
            clients_from_file.forEach(System.out::println);

            long time1 = System.currentTimeMillis();
            Loader.save(clients_from_file, connection);
            long time2 = System.currentTimeMillis();
            Loader.saveb(clients_from_file, connection);
            long time3 = System.currentTimeMillis();
            System.out.println();
            System.out.println(time2 - time1);
            System.out.println(time3 - time2);

            System.out.println();
            List<Client> clients = Loader.load(connection);
            System.out.println();
            System.out.println("Database:\n");
            if (clients != null) {
                List<Client> orderClients = Service.sortClientsByLastName(clients);
                orderClients.forEach(System.out::println);
                System.out.println();

                Client client = Service.findPersonByLastName(clients,"Иванов");
                System.out.println(client.toString());
            }

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}