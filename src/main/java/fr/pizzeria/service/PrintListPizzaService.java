package fr.pizzeria.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class PrintListPizzaService extends MenuService {
	public static final ResourceBundle file = ResourceBundle.getBundle("conf");
	public static final String path = file.getString("path.absolute");
	
	public void executeUC(PizzaMemDao dao) throws DocumentException, IOException {	
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(path));
			
			document.open();
			document.add(new Paragraph("Voici la liste des pizzas disponibles :"));
			
			List<Pizza> list = dao.findAllPizzas();
			for(int i = 0; i < list.size(); i++) {
				document.add(new Paragraph(dao.findAllPizzas().get(i).toString()));
			}
			
			LOG.info("Votre pdf est généré dans le chemin suivant : " + path);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		document.close();
	}
}
