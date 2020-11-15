package com.besd.SocialMediaAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.besd.SocialMediaAPI.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{
	

}
