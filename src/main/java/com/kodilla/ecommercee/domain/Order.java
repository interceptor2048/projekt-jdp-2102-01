package com.kodilla.ecommercee.domain;

//<<<<<<< HEAD
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "ORDERS")
//public class Order {
//
//    @Id
//    @GeneratedValue
//    @NotNull
//    @Column(name = "ORDER_ID", unique = true)
//=======
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "orders")
public class Order {
    @Id
    private Long id;

    @ManyToOne
    private User user;
}
