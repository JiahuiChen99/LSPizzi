package database;

public class DBQueries {
    private DBClient dbClient;

    // Getters queries
    final String getPizzas = "";
    final String getDoughs = "";
    final String getDrinks = "";
    final String getDelegations = "";
    final String getIngredients = "";
    final String getCustomerOrders = "";

    // Setters queries
    final String setCustomer = "";
    final String setOrder = "";

    // Bind the DB client singleton
    public DBQueries(DBClient dbClient) {
        this.dbClient = dbClient;
    }
}
