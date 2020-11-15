package com.besd.SocialMediaAPI.service;

import java.util.Date;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besd.SocialMediaAPI.entity.Post;
import com.besd.SocialMediaAPI.repository.UserRepository;
import com.besd.SocialMediaAPI.view.Following;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public User login(User user) throws Exception{
		User foundUser = repo.findByUsername(user.getUsername());
		if(foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return user;
		}else {
			throw new Exception("Invalid username or password.");
		}
	}
	
	public Following follow(Long userId, Long followId) throws Exception{
		User user = repo.findOne(userId);
		User follow = repo.findOne(followId);
		if(user == null || follow == null) {
			throw new Exception("User DOES NOT exist.");
		}
		user.getFollowing().add(follow);
		repo.save(user);
		return new Following(user);
	}
	
	public Following getFollowedUsers(Long userId) throws Exception{
		User user = repo.findOne(userId);
		if(user == null) {
			throw new Exception("User DOES NOT exist.");
		}
		return new Following(user);
	}
	
	public User updateProfilePic(Long userId, String url) throws Exception{
		User user = repo.findOne(userId);
		if(user == null) {
			throw new Exception("User DOES NOT exist.");
		}
		user.setProfilePicURL(url);
		return repo.save(user);
	}

}
