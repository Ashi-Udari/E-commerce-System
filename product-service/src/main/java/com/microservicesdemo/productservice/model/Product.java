package com.microservicesdemo.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data //to get setters and getters
public class Product {

    @Id //to specify this is unique identifier
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}