package fr.pizzeria.service;

import fr.pizzeria.model.PizzaMemDao;

public class ListerPizzasService extends MenuService {
	public void executeUC(PizzaMemDao dao) {
		System.out.println("Liste des pizzas \n");
		for(int i = 0; i < dao.findAllPizzas().size(); i++) {
			System.out.println(dao.findAllPizzas().get(i).getCode() 
					+ " -> " + dao.findAllPizzas().get(i).getLibelle() 
					+ " (" + dao.findAllPizzas().get(i).getPrix() + " €) "
					+ dao.findAllPizzas().get(i).getCategoriePizza());
		}	
	}
}
