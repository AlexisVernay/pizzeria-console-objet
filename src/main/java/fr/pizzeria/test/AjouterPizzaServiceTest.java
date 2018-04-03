package fr.pizzeria.test;

import java.util.Scanner;

import org.junit.Test;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.AjouterPizzaService;

public class AjouterPizzaServiceTest {
	@Test
	public void testExecuteUC() throws SavePizzaException{		
		AjouterPizzaService addMenu = new AjouterPizzaService();
		PizzaMemDao listPizza = new PizzaMemDao();
		
		addMenu.executeUC(listPizza, new Scanner(System.in));
	}
}
