package com.urprovider.shipping.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateShipmentResource {

    @NotNull
    private String address;
    @NotNull
    private Boolean status;
    @NotNull
    private Long suplierId;
    @NotNull
    private Long shopId;
    @NotNull
    private Long trackingNumber;
}
