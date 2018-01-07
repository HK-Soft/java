package corejava.chpater2.item3;

//A service class 
public class ProductServices {

	private static final ProductServices PRODUCT_SERVICES = new ProductServices();
	
	//Throw CantBeInstantiatedException
	//private static final ProductServices PRODUCT_SERVICES_TEST = new ProductServices();

	private ProductServices() throws CantBeInstantiatedException {
		if (PRODUCT_SERVICES != null)
			throw new CantBeInstantiatedException();
	}

	// Always return the same object
	public static ProductServices getInstance() {
		return PRODUCT_SERVICES;
	}

	// CRUD operation AND other DB operations

}
