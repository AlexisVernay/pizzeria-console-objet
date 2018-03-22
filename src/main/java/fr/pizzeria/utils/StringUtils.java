package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.model.Pizza;

public class StringUtils {
	public static String toStringUtils(Pizza pizza){
		Class<Pizza> cl = Pizza.class;	
		// Permet de récupérer la liste des attributs de la classe
		Field[] attributs = cl.getDeclaredFields();		
		String chaine = "";
		
		try {
			// Boucle sur les attributs
			for(Field attr : attributs){
				attr.setAccessible(true);
				// Permet de vérifier si une annotation est présente sur l'attribut
				if(attr.isAnnotationPresent(ToString.class)){
					// Je récupère l'annotation ToString
					ToString annotation = attr.getAnnotation(ToString.class);
					
					// Je récupère la valeur de la propriété upperCase de l'annotation
					boolean upperCase = annotation.upperCase();
					String separateur = annotation.separateur();
					
					// Récupération de la valeur de l'attribut dans l'instance courante
					Object value = attr.get(pizza);
					
					// Condition if pour appliquer le upperCase si cette dernier est true
					if(upperCase == true) {
						// Ajout de la valeur de l'attribut à la chaine de caractère
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
