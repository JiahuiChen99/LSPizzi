import database.DBClient;
import database.DBQueries;
import model.LSPizzi;

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
        DBQueries dbQueries = new DBQueries(dbClient);

        // Construct the whole model
        LSPizzi lSpizzi = new LSPizzi(
                dbQueries.getPizzas(),
                dbQueries.getIngredients(),
                dbQueries.getDoughs(),
                dbQueries.getDrinks()
        );

        // Close DB client singleton
        dbClient.closeConnection();
    }
}
