package com.urprovider.inventory.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResource {

    @NotNull
    @NotBlank
    private String name;
    private String category;
    private String image;
    private boolean available;
    private String description;
    private Long idSupplier;

}
