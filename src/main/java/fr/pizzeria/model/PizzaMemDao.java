package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class PizzaMemDao implements IPizzaDao {
	
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
		pizzaList.add(new Pizza(4, "CAN", "La canniblae", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.FROMAGE));
		pizzaList.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		pizzaList.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.EPICE));
	}
	
	public List<Pizza> findAllPizzas() {
		return pizzaList;
	}

	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		pizzaList.add(pizza);	
	}

	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		pizzaList.remove(findPizzaByCode(codePizza));
		pizzaList.add(pizza);
	}

	public void deletePizza(String codePizza) throws DeletePizzaException {
		pizzaList.remove(findPizzaByCode(codePizza));
	}

	public Pizza findPizzaByCode(String codePizza) {
		for(int i = 0; i < pizzaList.size(); i++) {
			if(pizzaList.get(i) != null && pizzaList.get(i).getCode().equals(codePizza)) {
				return pizzaList.get(i);
			}		
		}
		return null;
	}

	public boolean pizzaExists(String codePizza) {	
		return findPizzaByCode(codePizza)!=null;
	}

}
