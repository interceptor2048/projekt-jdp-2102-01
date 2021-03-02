package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {
    @Id
    private Long id;

    @ManyToMany(mappedBy = "products")
    private List<Cart> cartList;
}
