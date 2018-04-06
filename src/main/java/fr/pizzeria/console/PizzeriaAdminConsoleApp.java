package fr.pizzeria.console;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.DocumentException;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaDB;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.MenuServiceFactory;

public class PizzeriaAdminConsoleApp extends PizzaDB {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public static void main(String[] args) throws DocumentException, IOException {
		menu();

		@SuppressWarnings("resource")
		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;

		PizzaDB dao = new PizzaDB();

		MenuServiceFactory ser = new MenuServiceFactory();

		while(choice !=99) {
			choice = choiceUser.nextInt();

			if(choice == 99) {
				LOG.info("Aurevoir ☹ \n");
				break;
			}
			
			try {
				ser.getInstance(choice).executeUC(dao, new Scanner(System.in));
			} catch (StockageException e) {
				LOG.info("Erreur fatale");
				e.printStackTrace();
			}
			menu();	
		}
	}

	public static void menu()
	{
		LOG.info(" \n***** Pizzeria Administration ***** \n"
		+ "1. Lister les pizzas \n"
		+ "2. Ajouter une nouvelle pizza \n"
		+ "3. Mettre à jour une pizza \n"
		+ "4. Supprimer une pizza \n"
		+ "5. Imprimer la liste des pizza \n"
		+ "99. Sortir \n");


	}
}
