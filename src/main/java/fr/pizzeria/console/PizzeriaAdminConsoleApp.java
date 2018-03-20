package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		Pizza[] pizzaArray = new Pizza[8];
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
		int choice = choiceUser.nextInt();

		while(choice !=99) {
			switch(choice)
			{
				case 1:
					System.out.println("Liste des pizzas \n");
					for(int i = 0; i < pizzaArray.length; i++) {
						System.out.println(pizzaArray[i].getCode() + " -> " + pizzaArray[i].getLibelle() + " (" + pizzaArray[i].getPrix() + ")");
					}
					menu();
					choice = choiceUser.nextInt();
					break;
				case 2:
					System.out.println("Ajout d'une nouvelle pizza \n");
					menu();
					choice = choiceUser.nextInt();
					break;
				case 3:
					System.out.println("Mise à jour d’une pizza \n");
					menu();
					choice = choiceUser.nextInt();
					break;
				case 4:
					System.out.println("Suppression d'une pizza \n");
					menu();
					choice = choiceUser.nextInt();
					break;
				case 99:
					System.out.println("Aurevoir ☹ \n");
					break;
				default:
					System.out.println("Le numéro n'est pas attribué \n");
					menu();
					choice = choiceUser.nextInt();
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
