package com.besd.SocialMediaAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.besd.SocialMediaAPI.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

	Post findOne(Long postId);

}
