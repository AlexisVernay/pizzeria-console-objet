package fr.pizzeria.service;

import fr.pizzeria.model.PizzaMemDao;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao dao) {
		System.out.println("Veuillez choisir le code de la pizza à supprimer : \n");
		System.out.println(dao.findAllPizzas());
		
		code = choiceUser.next();
		dao.deletePizza(code);	
	}
}
