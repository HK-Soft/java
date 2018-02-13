package corejava.chpater2.item1.storage;

public interface StorageService<T> {

	public void put(String key,T value);
	
	public T get(String key);
	
}
