package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scan) throws UpdatePizzaException {
		LOG.info("\nVeuillez choisir le code de la pizza à modifier. \n");
		code = choiceUser.next();
		
		LOG.info("Veuillez saisir le nouveau code \n");
		String newCode = choiceUser.next();
		LOG.info("Veuillez saisir le nouveau nom (sans espace) \n");
		libelle = choiceUser.next();
		LOG.info("Veuillez saisir le nouveau prix \n");
		prix = Double.parseDouble(choiceUser.next());
		LOG.info("Veuillez saisir la catégorie \n");
		cat = choiceUser.next();
		
		if(!dao.pizzaExists(code))
		{			
			throw new UpdatePizzaException("Ce code n'existe pas");
		}

		dao.updatePizza(code, new Pizza(newCode, libelle, prix, CategoriePizza.valueOf(cat)));				
	}
}
