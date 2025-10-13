package com.yeditepe.firstapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class UserProfile {
    public UserProfile() {

    }

    enum Gender {
    MALE,
    FEMALE
}

    @Id
    private Long id;
    private Integer age;
    private String firstName;
    private String lastName;
    private Gender gender;
    @OneToOne
    private User user_id;




}
