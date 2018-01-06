package corejava.chpater2.item1.storage.memoryStorage;

import corejava.chpater2.item1.storage.StorageProvider;
import corejava.chpater2.item1.storage.StorageService;

public class InMemoryStorageProvider implements StorageProvider {

	public StorageService newStorage() {
		return new InMemoryStorage();
	}

}
