package corejava.chpater2.item1.storage.memoryStorage;

import corejava.chpater2.item1.storage.StorageProvider;
import corejava.chpater2.item1.storage.StorageService;

public class InMemoryStorageProvider<T> implements StorageProvider<T> {

	public StorageService<T> newStorage() {
		return new InMemoryStorage<T>();
	}

}
