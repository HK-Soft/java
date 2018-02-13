package corejava.chapter4.item13_16_19_20_22;

import corejava.chapter4.item19.services.CantBeServedException;
import corejava.chapter4.item19.services.RegularService;
import corejava.chapter4.item19.services.Service;
import corejava.chapter4.item19.services.VIPService;

//An organization that provide multiple levels service
public class ImageneryOrganization {

	// A service is a service only the service it's self
	// should know how to execute the service
	public static void server(Client client, Service service) {
		try {
			service.serve(client);
		} catch (CantBeServedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// An index of all active client
		ClientsRegestry regestry = ClientsRegestry.initRegestry();

		// Register clients
		Client client1 = new Client("firstname 1", "last name 1");
		Client client2 = new Client("firstname 2", "last name 2");
		regestry.register(client1);
		regestry.register(client2);

		// Serve clients
		if (regestry.isRegistered(client1))// serve only registered client
			ImageneryOrganization.server(client1, RegularService.getInstance());

		System.out.println('\n');

		if (regestry.isRegistered(client2))
			ImageneryOrganization.server(client1, VIPService.getInstance());

	}
}
