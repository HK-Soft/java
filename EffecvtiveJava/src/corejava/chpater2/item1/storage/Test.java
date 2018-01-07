package corejava.chpater2.item1.storage;

import corejava.chpater2.item1.storage.memoryStorage.InMemoryStorageProvider;

public class Test {
	public static void main(String[] args) {

		StorageHandler.registerDefaultProvider(new InMemoryStorageProvider<String>());

		// risk of type mismatch could generate run time error
		@SuppressWarnings("unchecked")
		StorageService<String> storage = (StorageService<String>) StorageHandler.newInstance();

		storage.put("key1", "object N 1");

		System.out.println(storage.get("key1"));
	}
}
