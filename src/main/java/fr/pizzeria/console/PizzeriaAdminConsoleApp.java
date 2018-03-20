package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		List<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza(0, "PEP", "Pépéronie", 12.50));
		pizzaList.add(new Pizza(1, "MAR", "Margherita", 14.00));
		pizzaList.add(new Pizza(2, "REIN", "La Reine", 11.50));
		pizzaList.add(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		pizzaList.add(new Pizza(4, "CAN", "La canniblae", 12.50));
		pizzaList.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		pizzaList.add(new Pizza(6, "ORI", "L'orientale", 13.50));
		pizzaList.add(new Pizza(7, "IND", "L'indienne", 14.00));

		menu();

		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;	
		int nbTab = 8;
		String code, libelle;
		double prix;
		
		while(choice !=99) {
			choice = choiceUser.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Liste des pizzas \n");
					for(int i = 0; i < pizzaList.size(); i++) {
						if(pizzaList.get(i) != null) {
							System.out.println(pizzaList.get(i).getCode() 
									+ " -> " + pizzaList.get(i).getLibelle() 
									+ " (" + pizzaList.get(i).getPrix() + " €)");
						}
					}
					menu();
					
					break;
				case 2:
					for(int i = 0; i < pizzaList.size() - 1; i++) {
						if(pizzaList.get(i) != null) {
							nbTab++;
						}
					}
					System.out.println("Veuillez saisir le code : \n");
					code = choiceUser.next();
					System.out.println("Veuillez saisir le nom (sans espace) : \n");
					libelle = choiceUser.next();
					System.out.println("Veuillez saisir le prix : \n");
					prix = Double.parseDouble(choiceUser.next());
					System.out.println("Ajout d'une nouvelle pizza \n");

					pizzaList.add(new Pizza(code, libelle, prix));	
					
					menu();
					break;
				case 3:
					System.out.println("Veuillez choisir le code de la pizza à modifier. \n");
					for(int i = 0; i < pizzaList.size(); i++) {
						if(pizzaList.get(i) != null) {
							System.out.println(pizzaList.get(i).getCode() 
									+ " -> " + pizzaList.get(i).getLibelle() 
									+ " (" + pizzaList.get(i).getPrix() + " €)");
						}
					}
					
					code = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau code \n");
					String newCode = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) \n");
					String newLibelle = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau prix \n");
					Double newPrix = Double.parseDouble(choiceUser.next());
				
					for(int i = 0; i < pizzaList.size(); i++) {
						if(pizzaList.get(i) != null && pizzaList.get(i).getCode().equals(code)) {
							pizzaList.get(i).setCode(newCode);
							pizzaList.get(i).setLibelle(newLibelle);
							pizzaList.get(i).setPrix(newPrix);
						}
					}
					
					menu();
					break;
				case 4:
					System.out.println("Veuillez choisir le code de la pizza à supprimer : \n");
					for(int i = 0; i < pizzaList.size(); i++) {
						if(pizzaList.get(i) != null) {
							System.out.println(pizzaList.get(i).getCode() 
									+ " -> " + pizzaList.get(i).getLibelle() 
									+ " (" + pizzaList.get(i).getPrix() + " €)");
						}
					}
					
					code = choiceUser.next();
					for(int i = 0; i < pizzaList.size(); i++) {
						if(pizzaList.get(i) != null && pizzaList.get(i).getCode().equals(code)) {
							pizzaList.remove(i);
						}		
					}
					
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
