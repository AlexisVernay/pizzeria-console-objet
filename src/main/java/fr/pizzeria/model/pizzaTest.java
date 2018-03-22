package fr.pizzeria.model;

public class pizzaTest {

	public static void main(String[] args) {
		Pizza piz1 = new Pizza(0, "GRE", "Grenobloise", 20.00, CategoriePizza.FROMAGE);
		System.out.println(piz1.toString());
	}

}
