package fr.pizzeria.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class PizzaMemDaoTest {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	@Test
	public void testFindAllPizza(){	
		PizzaMemDao list = new PizzaMemDao();
		List<Pizza> listPizza = list.findAllPizzas();
		Assert.assertNotNull(listPizza);
	}
		
	@Test
	public void testSaveNewPizza_ListBigger(){	
		PizzaMemDao list = new PizzaMemDao();
		Pizza pizza = new Pizza("NAN", "Nantaise", 15.00, CategoriePizza.POISSON);
		int oldNbPizza = list.findAllPizzas().size();
		
		list.saveNewPizza(pizza);
		
		Assert.assertNotEquals(oldNbPizza, list.findAllPizzas().size());
	}
	
	@Test
	public void testSaveNewPizza_NewPizzaVisible(){	
		PizzaMemDao list = new PizzaMemDao();
		Pizza pizza = new Pizza("NAN", "Nantaise", 15.00, CategoriePizza.POISSON);
		
		list.saveNewPizza(pizza);
		List<Pizza> listPizza = list.findAllPizzas();
		
		for(int i = 0; i < listPizza.size(); i++) {
			if(listPizza.get(i).getCode().equals("NAN")) {
				Assert.assertTrue(true);
			}	
		}
	}
	
	@Test
	public void testUpdatePizza_NewPizzaExist(){	
		PizzaMemDao list = new PizzaMemDao();
		Pizza pizza = new Pizza("BRE", "Bressoise", 15.00, CategoriePizza.VIANDE);
		String code = "PEP";
		
		list.updatePizza(code, pizza);
		List<Pizza> listPizza = list.findAllPizzas();
		
		for(int i = 0; i < listPizza.size(); i++) {
			if(listPizza.get(i).getCode().equals("BRE")) {
				Assert.assertTrue(true);
			}	
		}	
	}
	
	@Test
	public void testUpdatePizza_OldPizzaExist(){	
		PizzaMemDao list = new PizzaMemDao();
		Pizza pizza = new Pizza("BRE", "Bressoise", 15.00, CategoriePizza.VIANDE);
		String code = "PEP";
		
		list.updatePizza(code, pizza);
		List<Pizza> listPizza = list.findAllPizzas();
		
		for(int i = 0; i < listPizza.size(); i++) {
			if(listPizza.get(i).getCode().equals(code)) {
				Assert.assertFalse(false);
			}	
		}	

	}
	
	@Test
	public void testUpdatePizza_ListBigger(){	
		PizzaMemDao list = new PizzaMemDao();
		Pizza pizza = new Pizza("BRE", "Bressoise", 15.00, CategoriePizza.VIANDE);
		int oldNbPizza = list.findAllPizzas().size();
		String code = "PEP";
		
		list.updatePizza(code, pizza);
		
		Assert.assertEquals(oldNbPizza, list.findAllPizzas().size());
	}	
	
	@Test
	public void testDeletePizza(){	
		PizzaMemDao list = new PizzaMemDao();
		int oldNbPizza = list.findAllPizzas().size();
		
		String code = "IND";
		
		list.deletePizza(code);
		List<Pizza> listPizza = list.findAllPizzas();
		
		for(int i = 0; i < listPizza.size(); i++) {
			if(!listPizza.get(i).getCode().equals(code)){
				Assert.assertFalse(false);
			}
		}	
		
		Assert.assertNotEquals(oldNbPizza, listPizza.size());
	}
	
	@Test
	public void testFindPizzaByCode(){
		PizzaMemDao list = new PizzaMemDao();
		String code = "ORI";
		
		Pizza pizza = list.findPizzaByCode(code);
		Assert.assertTrue(list.pizzaExists(code));
		Assert.assertNotNull(pizza);
	}
}
