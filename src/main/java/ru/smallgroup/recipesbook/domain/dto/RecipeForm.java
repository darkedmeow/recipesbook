package ru.smallgroup.recipesbook.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ru.smallgroup.recipesbook.domain.Ingredient;
import ru.smallgroup.recipesbook.domain.Step;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeForm {

    private String title;
    private String tags;
    private List<Ingredient> ings = new ArrayList<>();
    private List<Step> steps = new ArrayList<>();
    private String time;
    private MultipartFile image;

}
