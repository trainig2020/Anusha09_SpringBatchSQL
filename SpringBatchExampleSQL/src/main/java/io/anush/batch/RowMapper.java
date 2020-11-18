package io.anush.batch;

import org.springframework.batch.item.file.LineMapper;

public class RowMapper implements LineMapper<String> {

	@Override
	public String mapLine(String line, int lineNumber) throws Exception {
		return line;
	}

}