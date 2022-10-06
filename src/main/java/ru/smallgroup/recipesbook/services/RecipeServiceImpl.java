package ru.smallgroup.recipesbook.services;

import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smallgroup.recipesbook.domain.Ingredient;
import ru.smallgroup.recipesbook.domain.Recipe;
import ru.smallgroup.recipesbook.domain.Step;
import ru.smallgroup.recipesbook.domain.dto.RecipeForm;
import ru.smallgroup.recipesbook.repositories.RecipeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{


    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe searchRecipeByTitle(String title) {
        return recipeRepository.findByTitle(title);
    }

    @Override
    public RecipeForm createRecipeForm() {
        RecipeForm recipeForm = new RecipeForm();
        recipeForm.getSteps().add(new Step());
        recipeForm.getIngs().add(new Ingredient());
        return recipeForm;
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void addStep(RecipeForm recipe) {
        recipe.getSteps().add(new Step());
    }

    @Override
    public void removeStep(RecipeForm recipe, Integer index) {
        if (recipe.getSteps().size() > 1)
            recipe.getSteps().remove(index.intValue());
    }

    @Override
    public void addIngredient(RecipeForm recipe) {
        recipe.getIngs().add(new Ingredient());
        log.debug("Result: " + recipe);
    }

    @Override
    public void removeIngredient(RecipeForm recipe, Integer index) {
        if (recipe.getIngs().size() > 1)
            recipe.getIngs().remove(index.intValue());
        log.debug("Result: " + recipe);
    }

    @Override
    public Recipe addRecipe(RecipeForm recipeForm) throws IOException {
        //TODO ~dtoConverter
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeForm.getTitle());
        recipe.setTags(Arrays.stream(recipeForm.getTags().split(" ")).toList());
        recipe.setIngredients(recipeForm.getIngs());
        recipe.setImage(new Binary(BsonBinarySubType.BINARY, recipeForm.getImage().getBytes()));
        recipe.setTime(recipeForm.getTime());
        recipe.setSteps(recipeForm.getSteps());

        recipeRepository.save(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> searchRecipesByTag(String tag) {
        return recipeRepository.findAllByTag(tag);
    }

    @Override
    public List<Recipe> searchRecipesByTag(List<String> tags) {
        //TODO оптимизировать
        List<Recipe> recipes = new ArrayList<>();
        for (String tag : tags) {
            recipes.addAll(recipeRepository.findAllByTag(tag));
        }
        return recipes;
    }
}
