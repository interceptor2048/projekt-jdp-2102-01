package com.kodilla.ecommercee.domian;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;

    @Column(name = "productName")
    @NotNull
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "price")
    @NotNull
    private Double price;

    @ManyToMany(mappedBy = "productList")
    private List<Cart> cartList;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Groups groups;

    @OneToMany(
            targetEntity = OrderItems.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItems> orderItems;

}
