package corejava.concurrency;

import java.util.concurrent.TimeUnit;

public class item66 {
	private static boolean stopRequested = false;

	private static synchronized void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					// System.out.println(stopRequested);
					i++;
				}
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}

}
