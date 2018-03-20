package fr.pizzeria.model;

public class Pizza {
		private
			int id;
			String code, libelle;
			double prix;
			
		public Pizza(String code, String libelle, double prix) 
		{
			id++;
			this.code = code;
			this.libelle = libelle;
			this.prix = prix;
		}
		
		public Pizza(int id, String code, String libelle, double prix) 
		{
			super();
			this.id = id;
			this.code = code;
			this.libelle = libelle;
			this.prix = prix;
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

}
