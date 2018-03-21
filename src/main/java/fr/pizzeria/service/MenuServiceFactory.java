package fr.pizzeria.service;

public class MenuServiceFactory {
	
	public MenuService getInstance(int choice){
		switch(choice){
		case 1 :
			ListerPizzasService list = new ListerPizzasService();
			return list;
		case 2 :
			AjouterPizzaService add = new AjouterPizzaService();
			return add;
		case 3 :
			ModifierPizzaService mod = new ModifierPizzaService();
			return mod;
		case 4 :
			SupprimerPizzaService del = new SupprimerPizzaService();
			return del;
		}
		return null;
	}
	
}
