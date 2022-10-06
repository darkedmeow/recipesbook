package ru.smallgroup.recipesbook.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.recipesbook.domain.Recipe;
import ru.smallgroup.recipesbook.domain.dto.RecipeForm;
import ru.smallgroup.recipesbook.services.RecipeService;

import java.io.IOException;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("search", "");
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("recipeForm", recipeService.createRecipeForm());
        return "test";
    }

    @PostMapping("/test")
    public String testResult(RecipeForm recipeForm, Model model) {
        log.debug(recipeForm.toString());
        return "index";
    }

    @PostMapping("/search")
    public String search(String search, Model model) throws IOException {
        Recipe recipe = recipeService.searchRecipeByTitle(search);
        model.addAttribute("recipeForm", recipe);
        model.addAttribute("img", recipe.getImage2String());
        return "result";
    }

    @PostMapping("/addRecipe")
    public String addRecipe(@ModelAttribute RecipeForm recipeForm, Model model) throws IOException {
        recipeService.addRecipe(recipeForm);
        return "redirect:/index";
    }

    @PostMapping("/addIng")
    public String addIng(RecipeForm recipeForm) {
        recipeService.addIngredient(recipeForm);
        return "test :: ingredients";
    }

    @PostMapping("/removeIng")
    public String removeIng(RecipeForm recipeForm,
                            @RequestParam("removeIng") Integer index) {
        recipeService.removeIngredient(recipeForm, index);
        return "test :: ingredients";
    }

    @PostMapping("/addStep")
    public String addStep(RecipeForm recipeForm) {
        recipeService.addStep(recipeForm);
        return "test :: steps";
    }

    @PostMapping("/removeStep")
    public String removeStep(RecipeForm recipeForm,
                             @RequestParam("removeStep") Integer index) {
        recipeService.removeStep(recipeForm, index);
        return "test :: steps";
    }

}
