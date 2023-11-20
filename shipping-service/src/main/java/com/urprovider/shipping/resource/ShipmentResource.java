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
public class ShipmentResource {

    private Long id;
    private String address;
    private Boolean status;
    private Long suplierId;
    private Long shopId;
    private Long trackingNumber;
}
