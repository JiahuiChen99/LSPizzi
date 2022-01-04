package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;


/**
 * DBClient represents the connection to the database
 * It uses the Singleton pattern
 */
public class DBClient {
    private String user = "root";
    private String psw = "root";
    private final String db_path = "jdbc:mysql://localhost:3306/pizzisalle";    // Localhost MySQL default port - pizzisalle DB
    private static Connection connection;

    private static DBClient db_client;

    // Creates a MySQL connection
    public DBClient() {
        // Load environment variables
        // For testing purposes 'user' & 'psw' are set directly
        // loadDBEnvironment();

        // Get a MySQL client connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(this.db_path, this.user, this.psw);
            if ( connection == null ) System.exit(-1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads system environment variables.
     * These will be used to get a connection to the DB,
     * hence an instance of DBClient
     */
    private void loadDBEnvironment() {
        this.user = System.getenv("PIZZI_DB_USER");
        this.psw = System.getenv("PIZZI_DB_PSW");
        if (Objects.equals(this.user, "") || Objects.equals(this.psw, "")) {
            System.out.println("Either PIZZI_DB_USER or PIZZI_DB_PSW System environment variables are not set up. Please configure it");
            System.exit(-1);
        }
    }

    /**
     * Retrieves the singleton instance of the connection
     * to the database.
     * It will create a new instance and return it back
     * if it's there's no instance
     * @return DBClient
     */
    public DBClient getConnection() {
        if ( db_client == null ) db_client = new DBClient();

        return db_client;
    }

    /**
     * Closes the client connection to the database
     * and removes the singleton instance
     * Called when before exiting the application
     */
    public void closeConnection() {
        if ( db_client != null ) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                db_client = null;
            }
        }
    }
}
