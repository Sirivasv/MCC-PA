package mx.unam.pa.spring.cli.hibernate;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mx.unam.pa.spring.cli.hibernate.config.HibernateConfig;
import mx.unam.pa.spring.cli.hibernate.model.Autor;
import mx.unam.pa.spring.cli.hibernate.service.AutorService;

/**
 * Clase principal
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Oct 4, 2019, 12:09:24 PM
 *
 */
public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(HibernateConfig.class) ){

			AutorService servicio = context.getBean(AutorService.class);
			List<Autor> listadoAutores = servicio.listarAutores();
			
			m.printAutores(listadoAutores);
			
			
			System.out.println("Creando nuevo usuario");
			Autor autor = new Autor("Richard", "Mattenson");
			servicio.guardar(autor);
			
			listadoAutores = servicio.listarAutores();
			m.printAutores(listadoAutores);
		}
	}
	
	public void printAutores(List<Autor> autores) {
		for(Autor autor : autores) {
			System.out.println(autor);
		}
	}
}
