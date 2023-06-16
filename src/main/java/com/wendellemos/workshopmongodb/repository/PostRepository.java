package com.wendellemos.workshopmongodb.repository;

import com.wendellemos.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> serchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
