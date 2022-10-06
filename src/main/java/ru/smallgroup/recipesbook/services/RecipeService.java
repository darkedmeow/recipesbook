package ru.smallgroup.recipesbook.services;

import ru.smallgroup.recipesbook.domain.Recipe;
import ru.smallgroup.recipesbook.domain.dto.RecipeForm;

import java.io.IOException;
import java.util.List;

public interface RecipeService {

    public Recipe searchRecipeByTitle(String title);
    public RecipeForm createRecipeForm();
    public Recipe addRecipe(Recipe recipe);
    public void addStep(RecipeForm recipe);
    public void removeStep(RecipeForm recipe, Integer index);
    public void addIngredient(RecipeForm recipe);
    public void removeIngredient(RecipeForm recipe, Integer index);
    public Recipe addRecipe(RecipeForm recipeForm) throws IOException;
    public List<Recipe> searchRecipesByTag(String tag);
    public List<Recipe> searchRecipesByTag(List<String> tags);

}
