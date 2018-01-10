package corejava.chapter4.item13_16_19_20_22;

import java.util.HashSet;
import java.util.Set;

//Registry for active clients
public class ClientsRegestry {

	// We always start with empty
	private final Set<Client> REGESTERD_CLIENTS = new HashSet<Client>();
	// Count of all (Present and Past) clients
	private int clientsCount = 0;

	private ClientsRegestry() {
	}

	public static ClientsRegestry initRegestry() {
		return new ClientsRegestry();
	}

	public void register(Client client) {
		REGESTERD_CLIENTS.add(client);
		clientsCount++;
	}

	public void unregisterClient(Client client) {
		REGESTERD_CLIENTS.remove(client);
	}

	public int getClientsCount() {
		return clientsCount;
	}

	// Find if the client exist
	public boolean isRegistered(Client client) {
		return REGESTERD_CLIENTS.contains(client);

	}
}
