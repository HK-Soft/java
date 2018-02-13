package corejava.chpater2.item1;

public class Item1 {
	public static void main(String[] args) {
	
		//
		Service helloService = () -> System.out.println("Say...Hello");
		Provider helloProvider = () -> {return helloService;};
		
		//
		Service defaultService = () -> System.out.println("Say...Hello Default");
		Provider defaultProvider = () -> {return defaultService;};
		
		//
		Services.registerProvider("Hello",helloProvider );
		Services.registerDefaultProvider(defaultProvider);
		
		//
		Services.newInstance("Hello").talk();
		Services.newInstance().talk();
		

	}
}
