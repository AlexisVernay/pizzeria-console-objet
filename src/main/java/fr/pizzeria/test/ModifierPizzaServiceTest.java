package fr.pizzeria.test;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.IPizzaDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.ModifierPizzaService;

public class ModifierPizzaServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();  
	
	private static final Logger LOGGER = LoggerFactory.getLogger("monLogger");
	
	@Test(expected=UpdatePizzaException.class)
	public void testExecuteUC() throws UpdatePizzaException{	
		LOGGER.info("Coucou");		
		systemInMock.provideLines("PEP", "GRE", "Grenobloise", "20", "FROMAGE");
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		
		when(mockedDao.findAllPizzas()).thenReturn(new ArrayList<>());
		doThrow(new UpdatePizzaException("Merde")).when(mockedDao).updatePizza(Mockito.anyString(), Mockito.any(Pizza.class));
		
		ModifierPizzaService mod = new ModifierPizzaService();					
		mod.executeUC(mockedDao, new Scanner(System.in));
		
	}
}
