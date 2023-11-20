package com.urprovider.users.store.resource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateStoreResource {
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String storeName;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @Size(max = 60)
    private String lastName;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String password;
    private Long phone;

    @Size(max = 60)
    private String address;

    @Size(max = 200)
    private String image;
}
