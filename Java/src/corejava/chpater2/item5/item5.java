package corejava.chpater2.item5;

public class item5 {

	private static final String TEST_STR = "A";

	// Testing Long VS long
	private static void testLongVslong() {
		long startTime = System.currentTimeMillis();
		Long sum1 = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum1 += i;
		}
		System.out.println("OP 'Long' Ended : Total = " + sum1 + " Time = " + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		long sum2 = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum2 += i;
		}
		System.out.println("OP 'long' Ended : Total = " + sum2 + " Time = " + (System.currentTimeMillis() - startTime));
	}

	// Testing String VS StringBuilder
	private static void testStringConcatenation() {

		long startTime = System.currentTimeMillis();
		String str = TEST_STR;
		for (short i = 0; i < Short.MAX_VALUE; i++) {
			str += TEST_STR;// Result in creating a new string
		}
		System.out.println(
				"OP 'String' Ended Time = " + (System.currentTimeMillis() - startTime) + " Size " + str.length());

		startTime = System.currentTimeMillis();
		StringBuilder strBuilderr = new StringBuilder();
		strBuilderr.append(TEST_STR);
		for (short i = 0; i < Short.MAX_VALUE; i++) {
			strBuilderr.append(TEST_STR);// uses the same string
		}
		System.out.println("OP 'StringBuilder' Ended Time = " + (System.currentTimeMillis() - startTime) + " Size "
				+ strBuilderr.length());
	}

	public static void main(String[] args) {

		testLongVslong();

		testStringConcatenation();
	}
}
