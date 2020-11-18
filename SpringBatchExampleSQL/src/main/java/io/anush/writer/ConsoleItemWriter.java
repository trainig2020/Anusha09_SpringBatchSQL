package io.anush.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import io.anush.model.User;

public class ConsoleItemWriter<T> implements ItemWriter<T> {
	@Override
	public void write(List<? extends T> items) throws Exception {
		for (T item : items) {
			User itemnew = (User) item;
			System.out.println(itemnew.toString());
		}
	}
}