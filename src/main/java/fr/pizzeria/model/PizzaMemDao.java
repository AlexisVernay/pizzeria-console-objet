package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaMemDao implements IPizzaDao  {
	
	private 
		List<Pizza> pizzaList = new ArrayList<>();
		String code, libelle;
		double prix;
		String cat;
		int nbTab = 8;
		
	public PizzaMemDao() {
		pizzaList.add(new Pizza(0, "PEP", "Pépéronie", 12.50, CategoriePizza.EPICE));
		pizzaList.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.FROMAGE));
		pizzaList.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.FROMAGE));
		pizzaList.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		pizzaList.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.EPICE));
	}
	
	public List<Pizza> findAllPizzas() {
		return pizzaList;
	}

	public void saveNewPizza(Pizza pizza) {
		pizzaList.add(pizza);	
	}

	@SuppressWarnings("unused")
	public void updatePizza(String codePizza, Pizza pizza) {
		if (pizzaList!= null) {
			Pizza optUpdate = findPizzaByCode(codePizza);
		}
		
	}

	public void deletePizza(String codePizza) {
		pizzaList.remove(findPizzaByCode(codePizza));
	}

	public boolean pizzaExists(String codePizza) {	
		return findPizzaByCode(codePizza)!=null;
	}
	
	public void printListPizza()  {
		
	}

}
