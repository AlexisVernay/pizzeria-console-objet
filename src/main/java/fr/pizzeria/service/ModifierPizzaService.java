package fr.pizzeria.service;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao dao) throws UpdatePizzaException {
		System.out.println("\nVeuillez choisir le code de la pizza � modifier. \n");
		code = choiceUser.next();
		
		System.out.println("Veuillez saisir le nouveau code \n");
		String newCode = choiceUser.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) \n");
		libelle = choiceUser.next();
		System.out.println("Veuillez saisir le nouveau prix \n");
		prix = Double.parseDouble(choiceUser.next());
		System.out.println("Veuillez saisir la cat�gorie \n");
		cat = choiceUser.next();
		
		if(!dao.pizzaExists(code))
		{			
			throw new UpdatePizzaException("Ce code n'existe pas");
		}

		dao.updatePizza(code, new Pizza(newCode, libelle, prix, CategoriePizza.valueOf(cat)));				
	}
}
