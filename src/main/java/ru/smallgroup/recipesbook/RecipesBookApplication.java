package ru.smallgroup.recipesbook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.smallgroup.recipesbook.domain.Recipe;
import ru.smallgroup.recipesbook.repositories.RecipeRepository;

import java.util.List;

@SpringBootApplication
public class RecipesBookApplication implements CommandLineRunner {


	@Autowired
	private RecipeRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(RecipesBookApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		repo.deleteAll();
//		repo.save(new Recipe("Test",
//				List.of("one", "two", "three"),
//				List.of("1", "2", "3"),
//				10L));
//		repo.save(new Recipe("Test2",
//				List.of("is", "a", "one"),
//				List.of("1", "2", "3"),
//				10L));
	}
}
