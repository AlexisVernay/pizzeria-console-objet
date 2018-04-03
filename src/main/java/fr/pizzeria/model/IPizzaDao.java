package fr.pizzeria.model;

import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public interface IPizzaDao {
	List<Pizza>findAllPizzas();
	
	void saveNewPizza(Pizza pizza) throws SavePizzaException;
	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	void deletePizza(String codePizza) throws DeletePizzaException;
	boolean pizzaExists(String codePizza);
	
	public default Pizza findPizzaByCode(String codePizza) {
		List<Pizza> pizzaList = findAllPizzas();
		
		if(pizzaList != null) {
			Optional<Pizza> opt = pizzaList.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();
			if(opt.isPresent()){
				return opt.get();
			}
		}
		return null;
	}
}
