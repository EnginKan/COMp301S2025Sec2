package com.yeditepe.firstapp.respository;

import com.yeditepe.firstapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    public List<Post> findByTitle(String title);

    @Query("SELECT P FROM Post P WHERE P.title= :title")
    public List<Post> findPostsByTitle(@Param("title") String title);

     @Query("SELECT P FROM Post P WHERE P.title like :start")
     public List<Post> findPostsByTitleLike(@Param("start") String start);

     public Set<Post> findDistinctByTitleLike(String title);

}
