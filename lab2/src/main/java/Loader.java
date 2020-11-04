import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import hotel.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Loader {
    public static List<Client> load(Connection connection) {
        String pgstr = "";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT content from clientb");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                pgstr = result.getString("content");
                System.out.println(pgstr);
            }
            statement.close();

            Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
            Client[] clients = gson.fromJson(pgstr, Client[].class);

            statement = connection.prepareStatement("SELECT content->0 as c from clientb");
            result = statement.executeQuery();
            while (result.next()) {
                pgstr = result.getString("c");
                System.out.println(pgstr);
            }

            return clients == null ? null : Arrays.asList(clients);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public static void save(List<Client> clients, Connection connection) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
            String personsAsJson = gson.toJson(clients);

            PreparedStatement statement = connection.prepareStatement(
                    "insert into client (content) values (cast( ? as json))");
            statement.setString(1, personsAsJson);

            int count = statement.executeUpdate();
            System.out.println(count + " records added!");

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void saveb(List<Client> clients, Connection connection) {

        try {
            Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
            String personsAsJson = gson.toJson(clients);
            PreparedStatement statement = connection.prepareStatement(
                    "insert into clientb (content) values (cast( ? as jsonb))");
            statement.setString(1, personsAsJson);

            int count = statement.executeUpdate();

            System.out.println(count + " records added!");

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}