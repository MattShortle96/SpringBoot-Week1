package com.besd.SocialMediaAPI.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besd.SocialMediaAPI.entity.Comment;
import com.besd.SocialMediaAPI.entity.Post;
import com.besd.SocialMediaAPI.entity.User;
import com.besd.SocialMediaAPI.repository.CommentRepository;
import com.besd.SocialMediaAPI.repository.PostRepository;
import com.besd.SocialMediaAPI.repository.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Comment createComment(Comment comment, Long userId, Long postId) throws Exception{
		User user = userRepo.findOne(userId);
		Post post = postRepo.findOne(postId);
		if(user == null || post == null) {
			throw new Exception("User or Post DOES NOT exist.");
		}
		comment.setDate(new Date());
		comment.setUser(user);
		comment.setPost(post);
		return repo.save(comment);
	}
	
	public void deleteComment(Long commentId) {
		repo.delete(commentId);
	}

}
