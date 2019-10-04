package mx.unam.progavanzada.practica.ejercicio16;

import mx.unam.progavanzada.practica.ejercicio15.Animal;

public class Tigre extends Animal implements Carnivoro {

	@Override
	public void comerCarne() {
		System.out.println("Cazando un antilope");
	}

	@Override
	public void comunicar() {
		System.out.println("ROAAAAAAAR!!");
	}

}
