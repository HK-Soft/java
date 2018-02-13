package corejava.chapter4.item19.services;

import corejava.chapter4.item13_16_19_20_22.Client;
import corejava.chpater2.item3.CantBeInstantiatedException;

//Needed as SINGLETON 
public class RegularService implements Service {

	private static final RegularService REGULAR_SERVICE = new RegularService();
	private static final String SERVICE_NAME = "this is a regulair service";
	private static final String SERVICE_CODE = "VIPS1";

	private RegularService() throws CantBeInstantiatedException {
		if (REGULAR_SERVICE != null)
			throw new CantBeInstantiatedException();
	}

	// Always return the same object
	public static RegularService getInstance() {
		return REGULAR_SERVICE;
	}

	public String code() {
		return SERVICE_CODE;
	}

	@Override
	public String name() {
		return SERVICE_NAME;
	}

	@Override
	public void serve(Client client) {
		System.out.println("Serving a client : ");
		System.out.println("Service name " + SERVICE_NAME);
		System.out.println(client);
		System.out.println("Serving a client Ended");
	}

}
