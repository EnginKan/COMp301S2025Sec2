package com.yeditepe.firstapp.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String description;

    @ManyToMany(mappedBy = "communities")
    Set<User> users;
    public Community() {}

}
