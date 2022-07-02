package ru.smallgroup.recipesbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RecipesBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesBookApplication.class, args);
	}

	@GetMapping("/start")
	public String start(@RequestParam(value = "name", defaultValue = "start") String name) {
		return String.format("This is %s", name);
	}

}
