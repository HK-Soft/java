package corejava.chpater2.item1.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class StorageHandler {

	private StorageHandler() {
	}

	private static final Map<String, StorageProvider<?>> providers = new ConcurrentHashMap<>();

	private static final String DEFAULT_PROVIDER_NAME = "<def>";

	public static void registerDefaultProvider(StorageProvider<?> p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}

	public static void registerProvider(String name, StorageProvider<?> p) {
		providers.put(name, p);
	}

	public static StorageService<?> newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public static StorageService<?> newInstance(String name) {
		StorageProvider<?> p = providers.get(name);
		if (p == null)
			throw new IllegalArgumentException("No provider registered with name: " + name);
		return p.newStorage();
	}
}
