package com.urprovider.sales.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urprovider.sales.shared.domain.model.BaseModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salesOrders")
@Builder
public class SalesOrder extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String date;
    private String description;

}
