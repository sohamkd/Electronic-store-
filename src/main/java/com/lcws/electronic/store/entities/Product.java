package com.lcws.electronic.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    private String productId;

    private String title;

    @Column(length = 5000)
    private String description;

    private int price;

    private int discountedProice;

    private int quantity;

    private Date addedDate;

    private boolean live;

    private boolean stock;
}
