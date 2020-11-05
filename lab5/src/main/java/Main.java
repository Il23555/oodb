import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/hotel";
            connection = DriverManager.getConnection(dbURL, "postgres", "7reu52dy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        assert connection != null;
        DB.add(connection);
        System.out.println("added!");
        DB.show(connection);
        System.out.println();

        DB.edit(connection);
        System.out.println("data changed!");
        DB.show(connection);
    }
}
