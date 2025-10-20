package com.yeditepe.firstapp.entity;


import jakarta.persistence.*;

import java.util.Set;

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
    @OneToMany(mappedBy = "owner",
    cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Post> posts;
    @ManyToMany()
    @JoinTable(
                    name="UserCommunity",
                    joinColumns = @JoinColumn(name="u_id"),
                    inverseJoinColumns = @JoinColumn(name= "c_id")
            )
    Set<Community> communities;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public Set<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(Set<Community> communities) {
        this.communities = communities;
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
