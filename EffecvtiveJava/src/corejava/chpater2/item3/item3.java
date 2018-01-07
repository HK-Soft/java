package corejava.chpater2.item3;

public class item3 {

	public static void main(String[] args) {

		ProductServices productServices = ProductServices.getInstance();
		System.out.println("First call : " + productServices.toString());
		
		productServices = ProductServices.getInstance();
		System.out.println("Second call : " + productServices.toString());
		
	}
}
