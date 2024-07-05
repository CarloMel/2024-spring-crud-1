package org.exercise.exercise;


import java.util.Optional;

import org.exercise.exercise.ContoBancario.pojo.ContoBancario;
import org.exercise.exercise.ContoBancario.serv.ContoBancarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {

	@Autowired
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
		contoBancarioService.save(c1);
		contoBancarioService.save(c2);
		contoBancarioService.save(c3);

		System.out.println("==================================================");

		contoBancarioService.getAllContiBancari()
							.stream()
							.forEach(System.out::println);


		System.out.println("==================================================");

		Optional<ContoBancario> oldCBOpt = contoBancarioService.getContoBancarioById(1);

		if (oldCBOpt.isEmpty()) {
			System.out.println("Conto bancario not found!");
			return;
		}

		ContoBancario oldCB = oldCBOpt.get();
		System.out.println(oldCB);

		oldCB.setSaldo(3000);

		contoBancarioService.save(oldCB);
		System.out.println(oldCB);
	}
}
