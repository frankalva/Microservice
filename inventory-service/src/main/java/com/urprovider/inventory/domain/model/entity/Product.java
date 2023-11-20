package com.urprovider.inventory.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urprovider.inventory.resource.ProductResource;
import com.urprovider.inventory.shared.domain.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;
    private String category;
    private String image;
    private boolean available=true;
    private String description;
    private int numberOfSales=1;
    private Long idSupplier;


    public static Product from(ProductResource productResource){
        Product product=new Product();
        product.setCategory(productResource.getCategory());
        return product;

    }
}
