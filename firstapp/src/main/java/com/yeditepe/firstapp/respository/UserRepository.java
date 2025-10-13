package com.yeditepe.firstapp.respository;

import com.yeditepe.firstapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    public List<User> findUserByName(String name);
    public User findUserByNameAndEmail(String name, String email);
}
