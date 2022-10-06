package ru.smallgroup.recipesbook.repositories;

import ru.smallgroup.recipesbook.domain.Recipe;

import java.util.List;

public interface CustomRecipeRepository {

    public List<Recipe> findAllByTag(String tag);
    public List<String> getIndexes();

}
