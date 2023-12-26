package com.lcws.electronic.store.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private String categoryId;

    @NotBlank
    @Size(min =4,message = "please enter minimum 4 charcaters name")
    private String title;

    @NotBlank(message = "Description required")
    @Size(min = 10,max = 100,message = "Description must be of minimum 10 charcters")
    private String description;

    @NotBlank(message = "cover image required")
    private String coverImage;
}
