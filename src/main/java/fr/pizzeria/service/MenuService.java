package fr.pizzeria.service;

import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaMemDao;

public abstract class MenuService {
	protected
		String code, libelle;
		double prix;
		String cat;
		Scanner choiceUser = new Scanner(System.in);
		int choice = 0;	
	
	public abstract void executeUC(PizzaMemDao dao) throws StockageException, DocumentException, IOException;
		
	public MenuService() {
			
	}
		
}
