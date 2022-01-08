# 🍕 LSPizzi

Patterns design course project

The user must ensure to run the pizzisalle.sql DB script before running the application.
This project implements the following software design patterns:

- MVC: The application itself uses this pattern to abstract different layers.
- Singleton: For the DB client, one and only instance.
- Builder: To customize and build the pizza.
- Factory Method: To use different constructors depending on the delegation.
- Iterator: To iterate through different elements.
- State: I was torn between "Chain of responsibility" or "State" behavioral design patterns, but finally chose 
this one to manage the state of the customer information input form.