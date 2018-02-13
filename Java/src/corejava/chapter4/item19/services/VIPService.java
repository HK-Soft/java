package corejava.chapter4.item19.services;

import corejava.chapter4.item13_16_19_20_22.Client;
import corejava.chpater2.item3.CantBeInstantiatedException;

//Needed as SINGLETON 
public class VIPService implements Service {

	private static final VIPService VIP_Service = new VIPService();
	private static final String SERVICE_NAME = "this is a regulair service";
	private static final String SERVICE_CODE = "REGS1";

	private VIPService() throws CantBeInstantiatedException {
		if (VIP_Service != null)
			throw new CantBeInstantiatedException();
	}

	// Always return the same object
	public static VIPService getInstance() {
		return VIP_Service;
	}

	public String code() {
		return SERVICE_CODE;
	}

	@Override
	public String name() {
		return SERVICE_NAME;
	}

	@Override
	public void serve(Client client) throws CantBeServedException {
		if(!isEligible(client)) {
			throw new EligibleClientException();
		}
		System.out.println("Serving a client : ");
		System.out.println("Service name " + SERVICE_NAME);
		System.out.println(client);
		System.out.println("Serving a client Ended");
	}

	//Test if the client is a VIP
	private boolean isEligible(Client client) {
		return true;
	}

}
