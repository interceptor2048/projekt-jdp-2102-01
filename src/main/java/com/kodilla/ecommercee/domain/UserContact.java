package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserContact {
    @OneToOne(
            targetEntity = User.class,
            mappedBy = "User_id",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private User user;

    @ManyToOne(targetEntity = User.class)
    private String email;

    @ManyToOne(targetEntity = User.class)
    private String phoneNumber;

    @ManyToOne(targetEntity = User.class)
    private String address;
}
