package corejava.serialization.clients;

public class Test {

	public static void main(String[] args) {

		ClientDTO moralClientDTO = new ClientDTO();
		moralClientDTO.description = "Flying White Heat Inc";
		moralClientDTO.address = "4833 Richards Avenue";
		moralClientDTO.title = "Logistician";
		moralClientDTO.firstname = "Ruth";
		moralClientDTO.lastname = "Colvard";
		moralClientDTO.email = "lauren1997@yahoo.com";
		moralClientDTO.phone = "860-824-4206";

		ClientDTO physicalientDTO = new ClientDTO();
		physicalientDTO.address = "4833 Richards Avenue";
		physicalientDTO.firstname = "Ruth";
		physicalientDTO.lastname = "Colvard";
		physicalientDTO.email = "lauren1997@yahoo.com";
		physicalientDTO.phone = "860-824-4206";

		try {
			ClientServices.newPhysicalClient(physicalientDTO);
			// Serializing the moralClient
			ClientServices.save((MoralClient) ClientServices.newMoralClient(moralClientDTO));
			System.out.println(ClientServices.loadMoralClient());
		} catch (InvalidClientDetailsException e) {
			System.out.println(e.getMessage());
		}
	}

}
