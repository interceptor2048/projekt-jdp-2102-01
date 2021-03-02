package com.kodilla.ecommercee.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "carts")
public class Cart {
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "productsInCarts",
            joinColumns = @JoinColumn(name = "cartId"),
                    inverseJoinColumns = @JoinColumn(name = "productId")
            )
    private List<Product> productList;

}
