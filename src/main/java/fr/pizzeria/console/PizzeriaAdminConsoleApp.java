package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp extends PizzaMemDao {
	public static void main(String[] args) {
	
		menu();

		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;	
		
		PizzaMemDao dao = new PizzaMemDao();
		
		ListerPizzasService list = new ListerPizzasService();
		AjouterPizzaService add = new AjouterPizzaService();
		ModifierPizzaService mod = new ModifierPizzaService();
		SupprimerPizzaService del = new SupprimerPizzaService();
		
		while(choice !=99) {
			choice = choiceUser.nextInt();
			switch(choice)
			{
				case 1:
					list.executeUC(dao);
					menu();					
					break;
				case 2:
					add.executeUC(dao);
					menu();
					break;
				case 3:
					list.executeUC(dao);
					mod.executeUC(dao);
					menu();
					break;
				case 4:
					del.executeUC(dao);
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
