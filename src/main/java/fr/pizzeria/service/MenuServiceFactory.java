package fr.pizzeria.service;

public class MenuServiceFactory {
	
	public MenuService getInstance(int choice){
		switch(choice){
		case 1 :
			MenuService list = new ListerPizzasService();
			return list;
		case 2 :
			MenuService add = new AjouterPizzaService();
			return add;
		case 3 :
			MenuService mod = new ModifierPizzaService();
			return mod;
		case 4 :
			MenuService del = new SupprimerPizzaService();
			return del;
		case 5 :
			MenuService pri = new PrintListPizzaService();
			return pri;
		}
		return null;
	}
	
}
