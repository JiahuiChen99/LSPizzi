import database.DBClient;

public class Main {

    /**
     * The application uses Model-View-Controller (MVC)
     */
    public static void main(String[] args) {

        // Get DB client singleton
        DBClient dbClient = DBClient.getConnection();

        // Close DB client singleton
        dbClient.closeConnection();
    }
}
