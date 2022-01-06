package database;

import model.delegation.Delegation;
import model.delegation.DelegationFactory;
import model.dough.Dough;
import model.drink.Drink;
import model.ingredient.Ingredient;
import model.pizza.Pizza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBQueries {
    private DBClient dbClient;

    // Getters queries
    final String getPizzas = "SELECT * FROM Pizza";
    final String getDoughs = "SELECT * FROM Massa";
    final String getDrinks = "SELECT * FROM Drink";
    final String getDelegations = "SELECT * FROM Delegation";
    final String getIngredients = "SELECT * FROM Ingredient";
    final String getCustomerOrders = "";
    final String getPizzaIngredients = "SELECT Ingredient.id_ingredient, Ingredient.name FROM Ingredient" +
            " INNER JOIN PizzaItem ON Ingredient.id_ingredient=PizzaItem.id_ingredient AND PizzaItem.id_pizza=?";

    // Setters queries
    final String setCustomer = "INSERT INTO Customer (name, surname1, surname2, phone_number, address, city) VALUES (?,?,?,?,?,?)";
    final String setCustomerOrder = "INSERT INTO COrder(id_customer, id_delegation) VALUES (?,?)";
    final String setPizza = "INSERT INTO OrderItem (id_pizza, id_massa, extra, id_order) VALUES (?,?,?,?)";
    final String setDrink = "INSERT INTO OrderItem (id_drink, id_order) VALUES (?,?)";

    // Bind the DB client singleton
    public DBQueries(DBClient dbClient) {
        this.dbClient = dbClient;
    }


    public List<Pizza> getPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        try {
            ResultSet rs = this.dbClient.getDBconn().createStatement().executeQuery(this.getPizzas);
            while ( rs.next() ) {
                Pizza pizza = new Pizza(rs.getInt("id_pizza"), rs.getString("name"));
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Get ingredients for all every pizza
        // Using Iterator pattern
        Iterator<Pizza> pizza_iterator = pizzas.iterator();
        while (pizza_iterator.hasNext()){
            Pizza pizza = (Pizza)pizza_iterator.next();
            pizza.setIngredients(getPizzasIngredients(pizza.getID()));
        }

        return pizzas;
    }

    /**
     * Get the ingredients of a pizza
     * @return the list of ingredients
     */
    public List<Ingredient> getPizzasIngredients( int pizza_id ) {
        List<Ingredient> pizza_ingredients = new ArrayList<>();
        try {
            PreparedStatement ps = this.dbClient.getDBconn()
                    .prepareStatement(this.getPizzaIngredients);
            ps.setInt(1, pizza_id);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                Ingredient ingredient = new Ingredient(rs.getInt("id_ingredient"), rs.getString("name"));
                pizza_ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pizza_ingredients;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        try {
            ResultSet rs = this.dbClient.getDBconn().createStatement().executeQuery(this.getIngredients);
            while ( rs.next() ) {
                Ingredient ingredient = new Ingredient(rs.getInt("id_ingredient"), rs.getString("name"));
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredients;
    }

    public List<Dough> getDoughs() {
        List<Dough> doughs = new ArrayList<>();
        try {
            ResultSet rs = this.dbClient.getDBconn().createStatement().executeQuery(this.getDoughs);
            while ( rs.next() ) {
                Dough dough = new Dough(rs.getInt("id_massa"), rs.getString("name"));
                doughs.add(dough);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doughs;
    }

    public List<Drink> getDrinks() {
        List<Drink> drinks = new ArrayList<>();
        try {
            ResultSet rs = this.dbClient.getDBconn().createStatement().executeQuery(this.getDrinks);
            while ( rs.next() ) {
                Drink drink = new Drink(rs.getInt("id_drink"), rs.getString("name"));
                drinks.add(drink);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drinks;
    }

    /**
     * Get all the delegations from the DB
     * The list of delegations is constructed with
     * a factory method.
     * Depending on the ID returned from the DB, this
     * will be used to create the appropriate delegation
     * @return list of delegations
     */
    public List<Delegation> getDelegations() {
        List<Delegation> delegations = new ArrayList<>();
        try {
            ResultSet rs = this.dbClient.getDBconn().createStatement().executeQuery(this.getDelegations);
            while ( rs.next() ) {
                Delegation delegation = DelegationFactory.getDelegation(rs.getInt("id_delegation"));
                delegations.add(delegation);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return delegations;
    }
}
