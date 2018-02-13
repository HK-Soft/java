package corejava.chpater2.item1.storage;

public interface StorageProvider<T> {

	public StorageService<T> newStorage();
}
