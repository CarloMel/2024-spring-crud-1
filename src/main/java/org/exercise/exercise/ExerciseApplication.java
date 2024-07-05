package org.exercise.exercise;

import org.exercise.exercise.ContoBancario.pojo.ContoBancario;
import org.exercise.exercise.ContoBancario.serv.ContoBancarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {

	private ContoBancarioService contoBancarioService;

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello World");

		System.out.println("==================================================");

		ContoBancario c1 = new ContoBancario(100);
		ContoBancario c2 = new ContoBancario(250);
		ContoBancario c3 = new ContoBancario(1600);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		// Questa linea fa crashare il programma
		// contoBancarioService.save(c1);

	}
}
