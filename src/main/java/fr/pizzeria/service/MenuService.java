package fr.pizzeria.service;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.DocumentException;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaMemDao;

public abstract class MenuService {
	protected
		String code, libelle;
		double prix;
		String cat;
		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;	
		static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);	
		
	public abstract void executeUC(PizzaMemDao dao) throws StockageException, DocumentException, IOException;
		
	public MenuService() {
			
	}
		
}
