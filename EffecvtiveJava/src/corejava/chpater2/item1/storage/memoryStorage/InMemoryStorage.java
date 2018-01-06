package corejava.chpater2.item1.storage.memoryStorage;

import java.util.HashMap;
import java.util.Map;

import corejava.chpater2.item1.storage.StorageService;

public class InMemoryStorage implements StorageService {
	
	private Map<String, Object> repository = new HashMap<>();
	
	public void put(String key, Object value) {
		repository.put(key, value);
	}

	public Object get(String key) {
		return repository.get(key);
	}

}
