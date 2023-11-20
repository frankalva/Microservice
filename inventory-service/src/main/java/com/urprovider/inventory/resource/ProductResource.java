package com.urprovider.inventory.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResource {
    private Long id;
    private String name;
    private String category;
    private String image;
    private boolean available;
    private String description;
    private int numberOfSales;
    private Long idSupplier;
}
