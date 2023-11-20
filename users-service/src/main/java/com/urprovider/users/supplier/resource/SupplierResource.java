package com.urprovider.users.supplier.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResource {
    private Long id;
    private String supplierName;
    private String name;
    private String lastName;
    private String image;
    private String email;
    private String address;
    private long ruc;
    private String category;
    private String description;
    private long phone;
    private String password;
    private int likes;
}
