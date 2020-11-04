package json;

import com.google.gson.Gson;
import hotel.Client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Save {

    public static void saveClientList(List<Client> clients) throws IOException {

        if (clients != null && clients.size() > 0) {
            Gson gson = new Gson();
            String clientsAsJson = gson.toJson(clients);
            System.out.println(clientsAsJson);
            try (OutputStream os = new FileOutputStream(new File("clients.json")))
            {
                os.write(clientsAsJson.getBytes("UTF-8"));
                os.flush();
            }

        }
    }
}
