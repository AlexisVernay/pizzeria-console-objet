package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao dao) {
		System.out.println("\nVeuillez choisir le code de la pizza à modifier. \n");
		code = choiceUser.next();
		System.out.println("Veuillez saisir le nouveau code \n");
		String newCode = choiceUser.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) \n");
		String newLibelle = choiceUser.next();
		System.out.println("Veuillez saisir le nouveau prix \n");
		Double newPrix = Double.parseDouble(choiceUser.next());
	
		dao.updatePizza(code, new Pizza(newCode, newLibelle, newPrix));	
	}

}
