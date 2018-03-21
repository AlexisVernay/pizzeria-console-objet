package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaMemDao implements IPizzaDao {
	
	private 
		List<Pizza> pizzaList = new ArrayList<>();
		String code, libelle;
		double prix;
		int nbTab = 8;
		
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
		return pizzaList;
	}

	public void saveNewPizza(Pizza pizza) {		
		pizzaList.add(pizza);	
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		String newCode = pizza.getCode(), newLibelle = pizza.getLibelle(); 
		Double newPrix = pizza.getPrix();
		for(int i = 0; i < pizzaList.size(); i++) {
			if(pizzaList.get(i) != null && pizzaList.get(i).getCode().equals(codePizza)) {
				pizzaList.get(i).setCode(newCode);
				pizzaList.get(i).setLibelle(newLibelle);
				pizzaList.get(i).setPrix(newPrix);
			}
		}
	}

	public void deletePizza(String codePizza) {
		for(int i = 0; i < pizzaList.size(); i++) {
			if(pizzaList.get(i) != null && pizzaList.get(i).getCode().equals(codePizza)) {
				pizzaList.remove(i);
			}		
		}
	}

	public Pizza findPizzaByCode(String codePizza) {
		for(int i = 0; i < pizzaList.size(); i++) {
			if(pizzaList.get(i) != null && pizzaList.get(i).getCode().equals(codePizza)) {
				System.out.println(pizzaList.get(i).getCode() 
						+ " -> " + pizzaList.get(i).getLibelle() 
						+ " (" + pizzaList.get(i).getPrix() + " €)");
			}		
		}
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		for(int i = 0; i < pizzaList.size(); i++) {
			if(pizzaList.get(i) != null && pizzaList.get(i).getCode().equals(codePizza)) {
				System.out.println("Cette pizza existe");
				return true;			
			}
			else{
				System.out.println("Cette pizza n'existe pas");
			}
		}	
		return false;
	}

}
