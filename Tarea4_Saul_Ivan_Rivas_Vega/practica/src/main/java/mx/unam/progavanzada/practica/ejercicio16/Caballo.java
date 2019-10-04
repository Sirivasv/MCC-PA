package mx.unam.progavanzada.practica.ejercicio16;

import mx.unam.progavanzada.practica.ejercicio15.Animal;

public class Caballo extends Animal implements Herbivoro{

	@Override
	public void comunicar() {
		System.out.println("<vale por un sonido característico de caballo>");
	}

	@Override
	public void comerHierba() {
		System.out.println("comiendo heno");
	}

}
