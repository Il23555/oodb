package json;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import hotel.Client;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Load {

    public static Client loadClient() throws IOException {
        Client client = null;
        String clientStr = "";

        File file = new File("client.json");
        if (file.exists()) {
            clientStr = new String(Files.readAllBytes(file.toPath()));
        }

        client = new Gson().fromJson(clientStr, Client.class);
        return client;
    }

    public static List<Client> loadClientList() throws IOException, JsonSyntaxException {
        String clStr = "";

        File file = new File("clients.json");
        if (file.exists()) {
            clStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File clients.json not found!");
        }

        Client[] plst = new Gson().fromJson(clStr, Client[].class);

        return Arrays.asList(plst);
    }
}