package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		Pizza[] pizzaArray = new Pizza[100];
		pizzaArray[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzaArray[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzaArray[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		pizzaArray[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		pizzaArray[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzaArray[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzaArray[6] = new Pizza(6, "ORI", "L’orientale", 13.50);
		pizzaArray[7] = new Pizza(7, "IND", "L’indienne", 14.00);

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
					for(int i = 0; i < pizzaArray.length; i++) {
						if(pizzaArray[i] != null) {
							System.out.println(pizzaArray[i].getCode() 
									+ " -> " + pizzaArray[i].getLibelle() 
									+ " (" + pizzaArray[i].getPrix() + " €)");
						}
					}
					menu();
					
					break;
				case 2:
					for(int i = 0; i < pizzaArray.length - 1; i++) {
						if(pizzaArray[i] != null) {
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
					
					nbTab++;
					pizzaArray[nbTab] = new Pizza(code, libelle, prix);	
					
					menu();
					break;
				case 3:
					System.out.println("Veuillez choisir le code de la pizza à modifier. \n");
					for(int i = 0; i < pizzaArray.length; i++) {
						if(pizzaArray[i] != null) {
							System.out.println(pizzaArray[i].getCode() 
									+ " -> " + pizzaArray[i].getLibelle() 
									+ " (" + pizzaArray[i].getPrix() + " €)");
						}
					}
					
					code = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau code \n");
					String newCode = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) \n");
					String newLibelle = choiceUser.next();
					System.out.println("Veuillez saisir le nouveau prix \n");
					Double newPrix = Double.parseDouble(choiceUser.next());
				
					for(int i = 0; i < pizzaArray.length; i++) {
						if(pizzaArray[i] != null && pizzaArray[i].getCode().equals(code)) {
							pizzaArray[i].setCode(newCode);
							pizzaArray[i].setLibelle(newLibelle);
							pizzaArray[i].setPrix(newPrix);
						}
					}
					
					menu();
					break;
				case 4:
					System.out.println("Veuillez choisir le code de la pizza à supprimer : \n");
					for(int i = 0; i < pizzaArray.length; i++) {
						if(pizzaArray[i] != null) {
							System.out.println(pizzaArray[i].getCode() 
									+ " -> " + pizzaArray[i].getLibelle() 
									+ " (" + pizzaArray[i].getPrix() + " €)");
						}
					}
					
					code = choiceUser.next();
					for(int i = 0; i < pizzaArray.length; i++) {
						if(pizzaArray[i] != null && pizzaArray[i].getCode().equals(code)) {
							pizzaArray[i] = pizzaArray[i+1];
							for(int j = i + 1; j < pizzaArray.length - 1; j++){
								pizzaArray[j] = pizzaArray[j+1];
							}
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
