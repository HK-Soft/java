package corejava.concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class item68 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 100; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("I'm running.. ");
				}
			});
		}

		Set<Callable<Void>> tasks = new HashSet<>();

		for (int i = 0; i < 100; i++) {
			tasks.add(new Callable<Void>() {

				@Override
				public Void call() throws Exception {
					System.out.println("I'm running from a group...");
					return null;
				}
			});
		}

		// executor.invokeAll(tasks);
		executor.invokeAny(tasks);

		executor.shutdown();
	}

}
