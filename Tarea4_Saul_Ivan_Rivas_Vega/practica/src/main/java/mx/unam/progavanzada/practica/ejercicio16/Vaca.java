package mx.unam.progavanzada.practica.ejercicio16;

import mx.unam.progavanzada.practica.ejercicio15.Animal;

public class Vaca extends Animal implements Herbivoro {

	@Override
	public void comerHierba() {
		System.out.println("Pastando en la granja");
	}

	@Override
	public void comunicar() {
		System.out.println("MUUUUUUUUUuuuuuuuuuuUUUUUUUUUUUUUuuuuuuu");
	}

}
