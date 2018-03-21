package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class PizzeriaAdminConsoleApp extends PizzaMemDao {
	public static void main(String[] args) {

		PizzaMemDao pizzaList = new PizzaMemDao();
		
		menu();

		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;	
		
		String code, libelle;
		double prix;
		
		while(choice !=99) {
			choice = choiceUser.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Liste des pizzas \n");
					pizzaList.findAllPizzas();
					menu();					
					break;
				case 2:
					pizzaList.findAllPizzas();
					System.out.println("Veuillez saisir le code : \n");
					code = choiceUser.next();
					System.out.println("Veuillez saisir le nom (sans espace) : \n");
					libelle = choiceUser.next();
					System.out.println("Veuillez saisir le prix : \n");
					prix = Double.parseDouble(choiceUser.next());
					System.out.println("Ajout d'une nouvelle pizza \n");

					pizzaList.saveNewPizza(new Pizza(code, libelle, prix));	
					
					menu();
					break;
				case 3:
					System.out.println("Veuillez choisir le code de la pizza à modifier. \n");
					System.out.println(pizzaList.findAllPizzas());
					
					code = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau code \n");
					String newCode = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) \n");
					String newLibelle = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau prix \n");
					Double newPrix = Double.parseDouble(choiceUser.next());
				
					pizzaList.updatePizza(code, new Pizza(newCode, newLibelle, newPrix));	
					
					menu();
					break;
				case 4:
					System.out.println("Veuillez choisir le code de la pizza à supprimer : \n");
					System.out.println(pizzaList.findAllPizzas());
					
					code = choiceUser.next();
					pizzaList.deletePizza(code);
					
					menu();
					break;		
				case 5:
					System.out.println("Trouver pizza");
					code = choiceUser.next();
					pizzaList.findPizzaByCode(code);
					
					menu();
					break;
				case 99:
					System.out.println("Aurevoir ☹ \n");
					break;
				default:
					System.out.println("Le numéro n'est pas attribué \n");
					menu();
					break;
			}
		}

	}

	public static void menu()
	{
		System.out.println(" \n***** Pizzeria Administration ***** \n"
		+ "1. Lister les pizzas \n"
		+ "2. Ajouter une nouvelle pizza \n"
		+ "3. Mettre à jour une pizza \n"
		+ "4. Supprimer une pizza \n"
		+ "99. Sortir \n");


	}
}
