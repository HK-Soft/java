package corejava.chpater2.item1.storage.memoryStorage;

import java.util.HashMap;
import java.util.Map;

import corejava.chpater2.item1.storage.StorageService;

public class InMemoryStorage<T> implements StorageService<T> {
	
	private Map<String, T> repository = new HashMap<>();
	
	public void put(String key, T value) {
		repository.put(key, value);
	}

	public T get(String key) {
		return repository.get(key);
	}

}
