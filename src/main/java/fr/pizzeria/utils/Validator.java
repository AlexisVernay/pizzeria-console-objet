package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public class Validator {
	public static void Valid(Object o) throws StockageException {
		Class<?> cl = o.getClass();	
		Field[] attributs = cl.getDeclaredFields();
	
		try {
			for(Field attr : attributs){
				attr.setAccessible(true);
				if(attr.isAnnotationPresent(Rule.class)){
					Rule annotation = attr.getAnnotation(Rule.class);
				
					double min = annotation.min();
				
					if(min <= attr.getDouble(Rule.class)) {
						throw new SavePizzaException("En dessous du minimum requis");		
					}		
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
