package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.model.IPizzaDao;

public class ListerPizzasService extends MenuService {
	public void executeUC(IPizzaDao dao, Scanner scan) {
		System.out.println("Liste des pizzas \n");
		for(int i = 0; i < dao.findAllPizzas().size(); i++) {
			System.out.println(dao.findAllPizzas().get(i).toString());
		}	
	}
}
