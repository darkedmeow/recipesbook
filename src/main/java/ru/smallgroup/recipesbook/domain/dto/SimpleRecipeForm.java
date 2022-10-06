package ru.smallgroup.recipesbook.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleRecipeForm {

    private String title;
    private String tags;
    private String ings;
    private int hours;
    private int minutes;
    private MultipartFile image;


}
