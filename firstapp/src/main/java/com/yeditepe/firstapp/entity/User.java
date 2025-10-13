package com.yeditepe.firstapp.entity;


import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id//set this field as PK of the database table
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name="username")
    String name;
    String email;
    //@Column(nullable = true)
    @OneToOne(mappedBy = "user_id"
    ,fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    UserProfile profile;



    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
