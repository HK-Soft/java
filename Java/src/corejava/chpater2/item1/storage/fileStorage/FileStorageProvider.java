package corejava.chpater2.item1.storage.fileStorage;

import corejava.chpater2.item1.storage.StorageProvider;
import corejava.chpater2.item1.storage.StorageService;

public class FileStorageProvider implements StorageProvider {

	public StorageService newStorage() {
		return new FileStorage();
	}

}
