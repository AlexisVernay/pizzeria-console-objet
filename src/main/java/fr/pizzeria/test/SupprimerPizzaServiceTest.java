package fr.pizzeria.test;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.SupprimerPizzaService;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

public class SupprimerPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();  
	
	@Test
	public void testExecuteUC() throws SavePizzaException{		
		SupprimerPizzaService delMenu = new SupprimerPizzaService();
		PizzaMemDao dao = new PizzaMemDao();
		
		try {
			systemInMock.provideLines("PEP");
			delMenu.executeUC(dao,  new Scanner(System.in));		
			
		} catch (DeletePizzaException e) {
			fail("Le test est en échec");
		}
	}
}
