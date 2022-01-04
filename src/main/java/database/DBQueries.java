package database;

import model.dough.Dough;
import model.drink.Drink;
import model.ingredient.Ingredient;
import model.pizza.Pizza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBQueries {
    private DBClient dbClient;

    // Getters queries
    final String getPizzas = "SELECT * FROM Pizza";
    final String getDoughs = "SELECT * FROM Massa";
    final String getDrinks = "SELECT * FROM Drink";
    final String getDelegations = "SELECT * FROM DELEGATION";
    final String getIngredients = "";
    final String getCustomerOrders = "";

    // Setters queries
    final String setCustomer = "";
    final String setOrder = "";

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

        return pizzas;
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
}
