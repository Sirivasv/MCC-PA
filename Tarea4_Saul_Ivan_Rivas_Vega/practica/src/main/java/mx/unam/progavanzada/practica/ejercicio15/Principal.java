package mx.unam.progavanzada.practica.ejercicio15;

public class Principal {
	public void hablarConAnimal(Animal animal) {
		animal.comunicar();
	}
	
	public static void main(String[] args) {
		System.out.println("Hablando con animales...");
		
		Principal p = new Principal();
		
		/*
		 * Equivalente a realizar:
		 * 
		 * Animal[] animalitos = new Animal[3];  <-- Solo se esta reservando un espacio en memoria para un arreglo de 3 animales  
		 * animalitos[0] = new Caballo();
		 * animalitos[1] = new Vaca();
		 * animalitos[2] = new Tigre();
		 */
		Animal[] animalitos = new Animal[] {
				new Caballo(),
				new Vaca(),
				new Tigre()
		};
		
		for(Animal animal : animalitos) {
			p.hablarConAnimal(animal);
		}
	}
}
