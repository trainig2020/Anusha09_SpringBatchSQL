package io.anush.batch;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import io.anush.model.User;


//@Component
public class Processor  implements ItemProcessor<User, User> {

	@Override
	public User process(User user) throws Exception {
	       System.out.println("entered into the processor");
	        return user;
	}

}