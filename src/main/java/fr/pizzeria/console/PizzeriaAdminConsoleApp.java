package fr.pizzeria.console;

import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.MenuServiceFactory;

public class PizzeriaAdminConsoleApp extends PizzaMemDao {
	public static void main(String[] args) throws DocumentException, IOException {	
		menu();

		@SuppressWarnings("resource")
		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;	
		
		PizzaMemDao dao = new PizzaMemDao();
		
		MenuServiceFactory ser = new MenuServiceFactory();
			
		while(choice !=99) {
			choice = choiceUser.nextInt();	
				
			try {
				ser.getInstance(choice).executeUC(dao);
			} catch (StockageException e) {
				System.out.println("Erreur fatale");
				e.printStackTrace();
			}
			menu();					
						
			if(choice == 99) {
				System.out.println("Aurevoir ☹ \n");
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
		+ "5. Imprimer liste des pizza \n"
		+ "99. Sortir \n");


	}
}
