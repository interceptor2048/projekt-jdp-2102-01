package com.kodilla.ecommercee.domian;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
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
            targetEntity = OrderItems.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItems> orderItems;

}
