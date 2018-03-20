package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaMemDao implements IPizzaDao {
	
	private 
		List<Pizza> pizzaList = new ArrayList<>();
		String code, libelle;
		double prix;
	
	public PizzaMemDao() {
		pizzaList.add(new Pizza(0, "PEP", "Pépéronie", 12.50));
		pizzaList.add(new Pizza(1, "MAR", "Margherita", 14.00));
		pizzaList.add(new Pizza(2, "REIN", "La Reine", 11.50));
		pizzaList.add(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		pizzaList.add(new Pizza(4, "CAN", "La canniblae", 12.50));
		pizzaList.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		pizzaList.add(new Pizza(6, "ORI", "L'orientale", 13.50));
		pizzaList.add(new Pizza(7, "IND", "L'indienne", 14.00));
	}
	
	public List<Pizza> findAllPizzas() {
		for(int i = 0; i < pizzaList.size(); i++) {
			if(pizzaList.get(i) != null) {
				System.out.println(pizzaList.get(i).getCode() 
						+ " -> " + pizzaList.get(i).getLibelle() 
						+ " (" + pizzaList.get(i).getPrix() + " €)");
			}
		}
		return pizzaList;
	}

	public void saveNewPizza(Pizza pizza) {	
		int nbTab = 8;
		
		for(int i = 0; i < pizzaList.size() - 1; i++) {
			if(pizzaList.get(i) != null) {
				nbTab++;
			}
		}

		pizzaList.add(pizza);	
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		
	}

	public void deletePizza(String codePizza) {
		
	}

	public Pizza findPizzaByCode(String codePizza) {
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		return false;
	}

}
