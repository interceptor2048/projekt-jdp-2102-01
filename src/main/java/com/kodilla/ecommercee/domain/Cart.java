package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "carts")
@Entity
public class Cart {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "Cart_id")
    private Long id;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_In_Cart",
            joinColumns = @JoinColumn(name = "Cart_id")
    )
    private List<Product> products;

    /*@ManyToMany(
            targetEntity = Order.class,
            cascade = CascadeType.ALL)
    private List<Order> orders;*/

}
