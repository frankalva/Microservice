package com.urprovider.pay.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayResource {
    private Long id;
    private Float amount;
    private Date date;
    private Long supplierId;
    private Long shopId;
}
