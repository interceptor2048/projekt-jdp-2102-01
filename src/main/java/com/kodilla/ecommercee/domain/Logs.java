package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "Logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Logs {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "Time")
    private Timestamp timestamp;

    @Column(name = "Info")
    private String info;

    public Logs(Timestamp timestamp, String info) {
        this.timestamp = timestamp;
        this.info = info;
    }
}
