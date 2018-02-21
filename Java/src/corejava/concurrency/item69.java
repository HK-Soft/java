package corejava.concurrency;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class item69 {
	public static Random rnd = new Random();

	public static void main(String[] args) throws InterruptedException {

		Map<Integer, Integer> map = new ConcurrentHashMap<>();
		// Well generate numbers without repetition
		Set<Callable<Void>> tasks = new HashSet<>();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			tasks.add(new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					int nbr = rnd.nextInt(10);
					map.putIfAbsent(nbr, nbr);
					// System.out.println(map.get(nbr));
					return null;
				}
			});
		}
		executor.invokeAll(tasks);
		executor.shutdown();
		for (Integer in : map.keySet())
			System.out.println(map.get(in));

	}
}
