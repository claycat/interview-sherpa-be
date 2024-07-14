package com.sherpa.interview.domain.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sherpa.interview.domain.user.User;

public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);
}
