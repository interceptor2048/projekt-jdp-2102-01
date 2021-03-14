package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String productName;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "price")
    @NotNull
    private Double price;

    @ManyToMany(mappedBy = "products")
    private List<Cart> cartList;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItem> orderItems;

    public Product(@NotNull Long id, @NotNull String productName, String productDescription, @NotNull Double price) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    public Product(@NotNull Long id, @NotNull String productName, String productDescription, @NotNull Double price, Group group) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.group = group;
    }
}
