package com.yeditepe.firstapp.respository;

import com.yeditepe.firstapp.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository
extends JpaRepository<UserProfile, Long> {
}
