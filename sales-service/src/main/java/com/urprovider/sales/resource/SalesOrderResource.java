package com.urprovider.sales.resource;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesOrderResource {
    private Long id;
    private String status;
    private String date;
    private String description;
}
