package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * DBClient represents the connection to the database
 * It uses the Singleton pattern
 */
public class DBClient {
    private String user = "";
    private String psw = "";
    private final String db_path = "jdbc:mysql://localhost:3306/pizzisalle";    // Localhost MySQL default port - pizzisalle DB
    private static Connection connection;

    private static DBClient db_client;

    // Creates a MySQL connection
    public DBClient() {
        // TODO: Load environment variables
        // Get a MySQL client connection
        try {
            connection = DriverManager.getConnection(this.db_path, this.user, this.psw);
            if ( connection == null ) System.exit(-1);
        } catch (SQLException e) {
            e.printStackTrace();
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
