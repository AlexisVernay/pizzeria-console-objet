package fr.pizzeria.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;

public class PizzaDB implements IPizzaDao {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);	
	public static final ResourceBundle file = ResourceBundle.getBundle("conf");
	public static final String pathAdress = file.getString("path.htmlDB");
	public static final String pathUser = file.getString("path.userHtmlDB");
	public static final String pathPwd = file.getString("path.pwdHtmlDB");
	
	public PizzaDB() {
		Connection myConnection = null;		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(pathAdress, pathUser, pathPwd);
			Statement statement = myConnection.createStatement();
			
			statement.executeQuery(
					"CREATE TABLE IF NOT EXISTS pizzas(CODE_PIZZA varchar(4) NOT NULL, "
					+ "LIBELLE_PIZZA text(50) NOT NULL, "
					+ "PRIX_PIZZA varchar(10) NOT NULL, "
					+ "CATEGORIE_PIZZA varchar(20) NOT NULL);");
			
			ResultSet resultat = statement.executeQuery("SELECT * FROM pizzas WHERE CODE_PIZZA IN('PEP', 'MAR', 'REIN', 'FRO', 'CAN', 'SAV', 'ORI', 'IND')");
			if(!resultat.next()) {			
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('PEP', 'Pépéronie', 12.50, 'EPICE');");
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('MAR', 'Margherita', 14.00, 'SANS_VIANDE');");
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('REIN', 'La Reine', 11.50, 'VIANDE');");
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('FRO', 'La 4 fromages', 12.00, 'FROMAGE');");
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('CAN', 'La cannibale', 12.50, 'VIANDE');");
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('SAV', 'La savoyarde', 13.00, 'FROMAGE');");
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('ORI', 'L''orientale', 13.50, 'POISSON');");
				statement.executeQuery(
						"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
						+ " VALUES ('IND', 'L''indienne', 14.00, 'EPICE');");	
			}
			
			myConnection.close();	
			
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());				
		}
		finally {
			try {
				if (myConnection != null)
					myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e1.getMessage());	
			}
		}
	}
	
	
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzaList = new ArrayList<>();
		Connection myConnection = null;		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(pathAdress, pathUser, pathPwd);
			Statement statement = myConnection.createStatement();
			
			ResultSet list = statement.executeQuery("SELECT * FROM pizzas"); 
			
			while(list.next()) {
				String code = list.getString("CODE_PIZZA");
				String libelle = list.getString("LIBELLE_PIZZA");
				Double prix = list.getDouble("PRIX_PIZZA");
				String catString = list.getString("CATEGORIE_PIZZA");
				CategoriePizza cat = CategoriePizza.valueOf(catString);
				pizzaList.add(new Pizza(code, libelle, prix, cat));
			}		
			list.close();
		} catch (SQLException | ClassNotFoundException e) {
			LOG.debug(e.getMessage());		
			try {
				myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e.getMessage());	
			}
		}
		finally {
			try {
				myConnection.close();
				if (myConnection != null)
					myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e1.getMessage());	
			}
		}
		return pizzaList;
	}

	public void saveNewPizza(Pizza pizza) {
		Connection myConnection = null;			
		try {	
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(pathAdress, pathUser, pathPwd);
			Statement statement = myConnection.createStatement();
			statement.executeQuery(
					"INSERT INTO pizzas(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
					+ " VALUES ('"
							+ pizza.getCode() + "', '" 
							+ pizza.getLibelle() + "', " 
							+ pizza.getPrix() + ", " 
							+ "upper('" + pizza.getCategoriePizza() + "'));");
			statement.close();
		} catch (SQLException | ClassNotFoundException e) {
			LOG.debug(e.getMessage());		
			try {
				myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e.getMessage());	
			}
		}
		finally {
			try {
				myConnection.close();
				if (myConnection != null)
					myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e1.getMessage());	
			}
		}
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		Connection myConnection = null;			
		try {	
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(pathAdress, pathUser, pathPwd);
			Statement statement = myConnection.createStatement();
			statement.executeQuery(
					"UPDATE pizzas SET " 
							+ "CODE_PIZZA = '" + pizza.getCode() + "', " 
							+ "LIBELLE_PIZZA = '" + pizza.getLibelle() + "', " 
							+ "PRIX_PIZZA = " + pizza.getPrix() + ", " 
							+ "CATEGORIE_PIZZA = upper('" + pizza.getCategoriePizza() + "') "
					+ "WHERE CODE_PIZZA = '" + codePizza + "';");
			statement.close();
		} catch (SQLException | ClassNotFoundException e) {
			LOG.debug(e.getMessage());		
			try {
				myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e.getMessage());	
			}
		}
		finally {
			try {
				myConnection.close();
				if (myConnection != null)
					myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e1.getMessage());	
			}
		}
	}

	public void deletePizza(String codePizza) {
		if (codePizza != null) {
			Connection myConnection = null;			
			try {	
				Class.forName("org.mariadb.jdbc.Driver");
				myConnection = DriverManager.getConnection(pathAdress, pathUser, pathPwd);
				Statement statement = myConnection.createStatement();
				statement.executeQuery(
					"DELETE FROM pizzas "
							+ "WHERE CODE_PIZZA = '" + codePizza + "';");
				statement.close();
			} catch (SQLException | ClassNotFoundException e) {
				LOG.debug(e.getMessage());		
				try {
					myConnection.rollback();
				} catch (SQLException e1) {
					LOG.debug(e.getMessage());	
				}
			}
			finally {
				try {
					myConnection.close();
					if (myConnection != null)
						myConnection.rollback();
				} catch (SQLException e1) {
					LOG.debug(e1.getMessage());	
				}
			}
		}
		
	}

	public boolean pizzaExists(String codePizza) {	
		return findPizzaByCode(codePizza)!=null;
	}
	
	public void printListPizza()  {
		
	}	
}
