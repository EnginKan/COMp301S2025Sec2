package com.yeditepe.firstapp.respository;

import com.yeditepe.firstapp.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository
extends JpaRepository<Community, Long> {

    @Query("SELECT C FROM Community C where C.name like ?1 and C.description like ?2")
    public List<Community> findCommunityByNameAndDescription(String name,String description);
}
