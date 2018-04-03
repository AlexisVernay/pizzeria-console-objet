package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.IPizzaDao;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scan) throws DeletePizzaException {
		LOG.info("Veuillez choisir le code de la pizza à supprimer : \n");	
		code = choiceUser.next();
		
		if(!dao.pizzaExists(code))
		{			
			throw new DeletePizzaException("Ce code n'existe pas");
		}
		
		dao.deletePizza(code);			
	}
}
