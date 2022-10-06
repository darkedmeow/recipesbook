package ru.smallgroup.recipesbook.repositories;

import org.springframework.data.mongodb.core.DefaultIndexOperations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import ru.smallgroup.recipesbook.config.AppConfig;
import ru.smallgroup.recipesbook.domain.Recipe;

import java.util.List;
import java.util.stream.Collectors;

public class CustomRecipeRepositoryImpl implements CustomRecipeRepository{

    private final MongoOperations mongoOps = new AppConfig().mongoTemplate();

    @Override
    public List<Recipe> findAllByTag(String tag) {
        BasicQuery query = new BasicQuery(String.format("{tags:'%s'}", tag));
        return mongoOps.find(query, Recipe.class);
    }

    //NOT WORKING
    @Override
    public List<String> getIndexes() {
        DefaultIndexOperations indexOperations = new DefaultIndexOperations(mongoOps,
                "recipe", null);
        return indexOperations.getIndexInfo().stream().map(IndexInfo::getName).toList();
    }
}
