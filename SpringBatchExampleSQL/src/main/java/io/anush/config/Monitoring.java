package io.anush.config;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import javax.batch.operations.JobRestartException;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;

import io.anush.controller.UserController;

public class Monitoring {

	public static void fileWatcherService() throws IOException, InterruptedException, JobParametersInvalidException,
			JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
		UserController lc = new UserController();
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path dir = Paths.get("C:Users\\anush\\SQLScripts");
			keyMap.put(dir.register(service, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY), dir);
			WatchKey watchkey;
			do {
				watchkey = service.take();
				Path eventdir = keyMap.get(watchkey);
				for (WatchEvent<?> event : watchkey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventpath = (Path) event.context();
					System.out.println(eventdir + " : " + kind + " : " + eventpath);
				}
			} while (watchkey.reset());
		}
	}

}