package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.model.Pizza;

public class StringUtils {
	public static String toStringUtils(Pizza pizza){
		Class<Pizza> cl = Pizza.class;	
		// Permet de r�cup�rer la liste des attributs de la classe
		Field[] attributs = cl.getDeclaredFields();		
		String chaine = "";
		
		try {
			// Boucle sur les attributs
			for(Field attr : attributs){
				attr.setAccessible(true);
				// Permet de v�rifier si une annotation est pr�sente sur l'attribut
				if(attr.isAnnotationPresent(ToString.class)){
					// Je r�cup�re l'annotation ToString
					ToString annotation = attr.getAnnotation(ToString.class);
					
					// Je r�cup�re la valeur de la propri�t� upperCase de l'annotation
					boolean upperCase = annotation.upperCase();
					String separateur = annotation.separateur();
					
					// R�cup�ration de la valeur de l'attribut dans l'instance courante
					Object value = attr.get(pizza);
					
					// Condition if pour appliquer le upperCase si cette dernier est true
					if(upperCase == true) {
						// Ajout de la valeur de l'attribut � la chaine de caract�re
						chaine += value.toString().toUpperCase() + separateur;
					}
					else{
						chaine += value + separateur;
					}			
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return chaine;
	}

}
