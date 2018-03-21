package fr.pizzeria.service;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class AjouterPizzaService extends MenuService {	
	public void executeUC(PizzaMemDao dao) throws SavePizzaException {
		dao.findAllPizzas();
		System.out.println("Veuillez saisir le code : \n");
		super.code = super.choiceUser.next();
		System.out.println("Veuillez saisir le nom (sans espace) : \n");
		super.libelle = super.choiceUser.next();
		System.out.println("Veuillez saisir le prix : \n");
		super.prix = Double.parseDouble(super.choiceUser.next());
		
		System.out.println("Ajout d'une nouvelle pizza \n");
		
		if(prix <= 0){
			throw new SavePizzaException("Votre saisie est incorrecte");
		}
		else{
			dao.saveNewPizza(new Pizza(code, libelle, prix));	
		}
	}

}
