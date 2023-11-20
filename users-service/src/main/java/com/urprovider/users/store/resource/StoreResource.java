package com.urprovider.users.store.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreResource {
    private Long id;
    private String storeName;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Long phone;
    private String address;
    private String image;
}
