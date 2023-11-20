package com.urprovider.pay.domain.model.entity;


import com.urprovider.shared.domain.model.BaseModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pays")
@Builder
public class Pay extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Float amount;
    @NotNull
    private Date date;

    @NotNull
    private Long supplierId;
    @NotNull
    private Long shopId;


}
