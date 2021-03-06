package fr.pizzeria.model;

import fr.pizzeria.utils.Rule;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

public class Pizza {
		
		private int id;
		@ToString(separateur = " -> ", upperCase = true)
		private String code;
		@ToString(separateur = " ")
		private String libelle;
		@Rule(min = 5)
		@ToString(separateur = "� (")
		private double prix;
		@ToString(separateur = ")", upperCase = true)
		private CategoriePizza cat;
			
		public Pizza(String code, String libelle, double prix, CategoriePizza cat) 
		{
			id++;
			this.code = code;
			this.libelle = libelle;
			this.prix = prix;
			this.cat = cat;
		}
		
		public Pizza(int id, String code, String libelle, double prix, CategoriePizza cat) 
		{
			super();
			this.id = id;
			this.code = code;
			this.libelle = libelle;
			this.prix = prix;
			this.cat = cat;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}
		
		public boolean equals(Object object) {
			// Permet de v�rifier � la fois que object est non NULL
			// et que c'est une instance de Pizza
			if (!(object instanceof Pizza)){
				return false;
			}
			Pizza other = (Pizza)object;
			
			if (this.code.equals(other.getCode())
				&& this.libelle.equals(other.getLibelle())
				&& this.prix==other.getPrix()){
					return true;
				}
			return false;
		}
		
		public String toString(){
			return StringUtils.toStringUtils(this);
		}

		public CategoriePizza getCategoriePizza() {
			return cat;
		}
		
		public void setCategoriePizza(CategoriePizza cat) {
			this.cat = cat;
		}

}
