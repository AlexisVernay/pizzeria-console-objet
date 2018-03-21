package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;

public abstract class MenuService {
	protected
		String code, libelle;
		double prix;
		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;	
	
	public abstract void executeUC(PizzaMemDao dao);
		
	public MenuService() {
			
	}
		
}
