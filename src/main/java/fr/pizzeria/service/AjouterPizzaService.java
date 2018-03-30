package fr.pizzeria.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.utils.Validator;

public class AjouterPizzaService extends MenuService {	
	
	public void executeUC(PizzaMemDao dao) throws SavePizzaException {
		dao.findAllPizzas();
		LOG.info("Veuillez saisir le code : \n");
		code = choiceUser.next();
		LOG.info("Veuillez saisir le nom (sans espace) : \n");
		libelle = choiceUser.next();
		LOG.info("Veuillez saisir le prix : \n");
		prix = Double.parseDouble(choiceUser.next());
		LOG.info("Veuillez saisir la cat�gorie : \n");
		cat = choiceUser.next();
		CategoriePizza categorie = CategoriePizza.valueOf(cat);
		
		LOG.info("Ajout d'une nouvelle pizza \n");
		
		if(prix <= 0){
			throw new SavePizzaException("Votre saisie est incorrecte");
		}
		
		try {
			Validator.Valid(dao);
			dao.saveNewPizza(new Pizza(code, libelle, prix, categorie));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
