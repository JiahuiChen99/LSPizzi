import controller.LSPizziController;
import database.DBClient;
import database.DBQueries;
import model.LSPizzi;
import view.OrderForm;

public class Main {

    /**
     * The user must ensure to run the pizzisalle.sql DB
     * script before running the application.
     *
     * This project implements the following software design
     * patterns:
     *
     * - MVC: The application itself uses this pattern to abstract
     *      different layers.
     * - Singleton: For the DB client, one and only instance
     * - Builder: To customize and build the pizza.
     * - Factory Method: To use different constructors depending
     *      on the delegation
     * - Iterator: To iterate through different elements
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
                dbQueries.getDrinks(),
                dbQueries.getDelegations()
        );

        // Construct the whole view
        OrderForm orderForm = new OrderForm();

        // Construct and map the controller with the model & view
        LSPizziController lsPizziController = new LSPizziController(
                lSpizzi,
                orderForm,
                dbQueries
        );

        // Run the restaurant
        lsPizziController.runPizzi();

        // Close DB client singleton
        dbClient.closeConnection();
    }
}
