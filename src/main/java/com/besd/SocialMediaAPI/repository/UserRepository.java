package com.besd.SocialMediaAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.besd.SocialMediaAPI.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUsername(String username);
}
