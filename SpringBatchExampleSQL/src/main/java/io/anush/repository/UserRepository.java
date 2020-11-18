package io.anush.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.anush.model.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	void save(List<? extends User> users);

}