package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User{
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "User_id")
    private Long id;

    @NotNull
    @Column(name = "Username")
    private String userName;

    @Column(name = "Status")
    @NotNull
    private boolean status=true;

    @NotNull
    @Column(name = "userKey")
    private Long userKey;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    public User(@NotNull String userName) {
        this.userName = userName;
    }

    public User(@NotNull Long id, @NotNull String userName, @NotNull boolean status, @NotNull Long userKey) {
        this.id = id;
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
    }
    private LocalDateTime localDateTime;
}
