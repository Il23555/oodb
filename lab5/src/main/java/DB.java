import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

    public static void add(Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO hotel_client(client.lastname, client.firstname, client.document, client.phone) VALUES (?,?,?,?)");

            statement.setString(1, "Иванов");
            statement.setString(2, "Андрей");
            statement.setString(3, "8010976968");
            statement.setString(4, "89374756999");
            statement.executeUpdate();

            statement.setString(1, "Островская");
            statement.setString(2, "Анна");
            statement.setString(3, "8014779568");
            statement.setString(4, "89174756810");
            statement.executeUpdate();

            statement.setString(1, "Павлов");
            statement.setString(2, "Евгений");
            statement.setString(3, "8010977699");
            statement.setString(4, "89374779782");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void show(Connection connection) {
        PreparedStatement statementClient;
        try {
            statementClient = connection.prepareStatement("SELECT (client).firstname, (client).lastname, (client).document, (client).phone from hotel_client;");
            ResultSet client = statementClient.executeQuery();
            while (client.next()) {
                System.out.println(client.getString(1) + " " + client.getString(2) + " " +
                        client.getString(3) + " " + client.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void edit(Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE hotel_client set client.firstname='Мария' where (client).lastname like 'Островская'");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
