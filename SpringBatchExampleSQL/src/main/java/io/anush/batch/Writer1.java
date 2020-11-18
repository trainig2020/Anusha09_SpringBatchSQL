package io.anush.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.anush.model.User;
import io.anush.repository.UserRepository;

//@Component
public class Writer1 implements ItemWriter<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends User> users) throws Exception {

		System.out.println("Data Saved for Users: " + users);
		userRepository.saveAll(users);
	}

}