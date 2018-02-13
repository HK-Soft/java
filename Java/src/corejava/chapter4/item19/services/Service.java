package corejava.chapter4.item19.services;

import corejava.chapter4.item13_16_19_20_22.Client;

public interface Service {

	//Uniquely identifying code
	public String code();
	
	//Human readable name
	public String name();
	
	//execute the service
	public void serve(Client client) throws CantBeServedException;

}
