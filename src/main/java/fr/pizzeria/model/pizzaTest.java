package fr.pizzeria.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;

public class pizzaTest {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public static void main(String[] args) {
		Pizza piz1 = new Pizza(0, "GRE", "Grenobloise", 20.00, CategoriePizza.FROMAGE);
		LOG.info(piz1.toString());
	}

}
