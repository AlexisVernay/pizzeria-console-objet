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

	public String getCategoriePizza() {
		return libelle;
	}
	
	public static boolean exists(String chaine){
		CategoriePizza[] categs = values();
		
		for (int i = 0; i < categs.length; i++){
			if (categs[i].name().equals(chaine)){
				return true;
			}
		}
		return false;
	}
}
