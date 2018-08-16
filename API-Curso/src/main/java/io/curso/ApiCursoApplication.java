package io.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.curso.model.Cursos;
import io.curso.repository.CursoRepository;

@SpringBootApplication
public class ApiCursoApplication implements CommandLineRunner{

	@Autowired
	private CursoRepository cr;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiCursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cr.save(new Cursos("Rafael 1", "UNINOVE 1"));
		cr.save(new Cursos("Rafael 2", "UNINOVE 2"));
		cr.save(new Cursos("Rafael 3", "UNINOVE 3"));
		cr.save(new Cursos("Rafael 4", "UNINOVE 4"));
		cr.save(new Cursos("Rafael 5", "UNINOVE 5"));
		cr.save(new Cursos("Rafael 6", "UNINOVE 6"));
	}
}
