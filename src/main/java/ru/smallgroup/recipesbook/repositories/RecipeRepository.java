package ru.smallgroup.recipesbook.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.smallgroup.recipesbook.domain.Recipe;

import java.util.List;


public interface RecipeRepository extends MongoRepository<Recipe, String>, CustomRecipeRepository {

    public Recipe findByTitle(String title);

//    @Query("{tags: '?0' ")
//    public List<Recipe> findByTag(String tag);

}
