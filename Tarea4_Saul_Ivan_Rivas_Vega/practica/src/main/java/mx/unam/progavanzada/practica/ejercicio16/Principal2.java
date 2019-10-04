package mx.unam.progavanzada.practica.ejercicio16;

import mx.unam.progavanzada.practica.ejercicio15.Animal;
import mx.unam.progavanzada.practica.ejercicio15.Principal;

/**
 * 
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Sep 26, 2019, 10:04:12 PM
 *
 */
public class Principal2 extends Principal{
	public static void main(String[] args) {
		Principal2 principal2 = new Principal2();
		
		Animal[] animalitos = new Animal[] {
				new Caballo(),
				new Vaca(),
				new Tigre()
		};
		
		for(Animal animal : animalitos) {
			principal2.hablarConAnimal(animal);
			
			// No se pidió pero este es un ejemplo de instanceof y downcast
			if( animal instanceof Tigre ) {
				((Tigre) animal).comerCarne();
			}else if( animal instanceof Vaca ) {
				((Vaca) animal).comerHierba();
			}else {
				((Caballo) animal).comerHierba();
			}
			
			System.out.println();
		}
	}
}
