import database.DBClient;

public class Main {

    /**
     * The user must ensure to run the pizzisalle.sql DB
     * script before running the application.
     *
     * This project implements the following software design
     * patterns:
     *
     * - MVC: The application itself uses this pattern abstract
     *      different layers.
     * - Singleton: For the DB client, one and only instance
     * - Builder: To customize and build the pizza.
     */
    public static void main(String[] args) {

        // Get DB client singleton
        DBClient dbClient = DBClient.getConnection();

        // Close DB client singleton
        dbClient.closeConnection();
    }
}
