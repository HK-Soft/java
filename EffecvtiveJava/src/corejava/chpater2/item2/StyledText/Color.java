package corejava.chpater2.item2.StyledText;

public class Color {

	private Color() {
		
	}
	
	//Color from RED GREEN BLUE coding
	public static Color decodeRGB(short red,short green,short blue) {
		return new Color();
	}
	
	//Color using Hue saturation lightness coding style 
	//H: 0-360.
	//S: 0-100.
	//L: 0-100.
	public static Color decodeHSL(short hue,short saturation,short lightness) {
		return new Color();
	}
	
	//Color intended to be printed
	//C: 0-100
	//M: 0-100
	//Y: 0-100
	//B: 0-100
	public static Color decodeCMYK(short cyan,short magenta,short yallow ,short black) {
		return new Color();
	}
	
	//Default color retrieved by name 'BLACK RED GREEN ...etc'
	public static Color namedColor(String colorName) {
		return new Color();
	}
}
