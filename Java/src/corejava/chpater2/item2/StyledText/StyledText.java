package corejava.chpater2.item2.StyledText;

//Better implementation is to separate the style from the content to be style
//To be able to use the same style for different content
//Combined for the sake of this case simplicity 
@SuppressWarnings("unused")
public class StyledText {

	// Text to be styled
	private String text;

	// Style information
	private String fontName;
	private boolean isBold;
	private boolean isItalic;
	private boolean isUnderLined;
	private short size;
	private Alignement alignement;
	private Color foreground;
	private Color background;

	private StyledText(StyledTextBuilder builder) {
		this.text = builder.text;
		this.fontName = builder.fontName;
		this.isBold = builder.isBold;
		this.isItalic = builder.isItalic;
		this.isUnderLined = builder.isUnderLined;
		this.size = builder.size;
		this.alignement = builder.alignement;
		this.foreground = builder.foreground;
		this.background = builder.background;
	}

	private static class StyledTextBuilder {

		// Text to be styled
		private String text;

		// Style information
		private String fontName = "Arial";// the most supported style of font
		private boolean isBold = false;
		private boolean isItalic = false;
		private boolean isUnderLined = false;
		private short size = 11;// Why not !
		private Alignement alignement = Alignement.RIGHT_TO_LEFT;
		private Color foreground = Color.namedColor("BLACK");
		private Color background = Color.namedColor("WHITE");

		// Only the text is required
		// use default value for styling unless otherwise
		public StyledTextBuilder(String text) {
			this.text = text;
		}

		// Setter
		public StyledTextBuilder fontName(String fontName) {
			this.fontName = fontName;
			return this;
		}

		public StyledTextBuilder isBold() {
			this.isBold = true;
			return this;
		}

		// Convenient method 'have better readability then setter with (false or true)
		public StyledTextBuilder isNotBold() {
			this.isBold = false;
			return this;
		}

		public StyledTextBuilder isItalic() {
			this.isItalic = true;
			return this;
		}

		public StyledTextBuilder isNotItalic() {
			this.isItalic = false;
			return this;
		}

		public StyledTextBuilder isUnderLined() {
			this.isUnderLined = true;
			return this;
		}

		public StyledTextBuilder isNotUnderLined() {
			this.isUnderLined = false;
			return this;
		}

		public StyledTextBuilder size(short size) {
			this.size = size;
			return this;
		}

		public StyledTextBuilder alignement(Alignement alignement) {
			this.alignement = alignement;
			return this;
		}

		public StyledTextBuilder foreground(Color color) {
			this.foreground = color;
			return this;
		}

		public StyledTextBuilder background(Color color) {
			this.background = color;
			return this;
		}

		public StyledText render() {
			return new StyledText(this);
		}
	}

	public static void main(String[] args) {
		//Main header
		StyledText pageTitle = new StyledText.StyledTextBuilder("Introduction to java core")
								.size((short) 18)
								.alignement(Alignement.CENTER)
								.isBold()
								.isUnderLined()
							.render();
		
		StyledText subTitle = new StyledText.StyledTextBuilder("Item 1")
								.size((short) 16)
								.alignement(Alignement.LEFT_TO_RIGHT)
							.render();
		
		StyledText simpleText = new StyledText
									.StyledTextBuilder("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
									.render(); 
	}
	
}
