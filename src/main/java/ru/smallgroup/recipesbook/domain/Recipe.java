package ru.smallgroup.recipesbook.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class Recipe {

    @Id
    private String id;

    private String title;
    private Binary image;
    @Indexed
    private List<String> tags;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private String time;

    public Recipe(String title, Binary image, List<String> tags, List<Ingredient> ingredients, List<Step> steps, String totalTime) {
        this.title = title;
        this.image = image;
        this.tags = tags;
        this.ingredients = ingredients;
        this.steps = steps;
        this.time = totalTime;
    }

    public String getImage2String() {
        return Base64.getEncoder().encodeToString(image.getData());
    }
}
