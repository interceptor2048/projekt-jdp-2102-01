package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "`groups`")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "Id")
    private Long id;

    @Column(name = "groupName")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productList;

    public Group(@NotNull Long id, String groupName) {

        this.id = id;
        this.groupName = groupName;
    }
}