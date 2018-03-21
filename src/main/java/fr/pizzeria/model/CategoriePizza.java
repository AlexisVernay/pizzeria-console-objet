package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE ("Viande"), 
	POISSON ("Poisson"), 
	SANS_VIANDE ("Sans Viande"),
	EPICE ("Epicé"),
	FROMAGE ("Fromage");
	
	private String libelle;
	
	private CategoriePizza(String libelle){
		this.libelle = libelle;
	}

	public String toString(){
		return libelle;
	}
	
}
