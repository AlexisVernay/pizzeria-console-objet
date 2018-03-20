package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		switch(menu())
		{
		case 1:
			System.out.println("Liste des pizzas");
			main(args);
			break;
		case 2:
			System.out.println("Ajout d'une nouvelle pizza");
			main(args);
			break;
		case 3:
			System.out.println("Mise à jour d’une pizza");
			main(args);
			break;
		case 4:
			System.out.println("Suppression d'une pizza");
			main(args);
			break;
		case 99:
			System.out.println("Aurevoir ☹");
			break;	
		default:
			System.out.println("Le numéro n'est pas attribué");
			main(args);
			break;
		}
	}
	
	public static int menu() 
	{
		System.out.println("***** Pizzeria Administration ***** \n"
					+ "1. Lister les pizzas \n"
					+ "2. Ajouter une nouvelle pizza \n"
					+ "3. Mettre à jour une pizza \n"
					+ "4. Supprimer une pizza \n"
					+ "99. Sortir \n");
			
		Scanner choiceUser = new Scanner(System.in);
		int choice = choiceUser.nextInt();
		return choice;
	}
	


}
