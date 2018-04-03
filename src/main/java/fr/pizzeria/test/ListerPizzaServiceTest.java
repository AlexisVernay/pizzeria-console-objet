package fr.pizzeria.test;

import java.util.Scanner;

import org.junit.Test;

import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.ListerPizzasService;

public class ListerPizzaServiceTest {
	
	@Test
	public void testExecuteUC(){		
		ListerPizzasService listMenu = new ListerPizzasService();
		PizzaMemDao listPizza = new PizzaMemDao();
		
		listMenu.executeUC(listPizza, new Scanner(System.in));
	}
}
