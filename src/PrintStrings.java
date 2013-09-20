import java.util.concurrent.CountDownLatch;

public class PrintStrings {

	volatile int count = 0;
	class PrinterThread implements Runnable {

		String[] sentence;
		CountDownLatch latch;
		public PrinterThread(String[] sentence, CountDownLatch latch) {
			this.sentence = sentence;
			this.latch = latch;		
		}

		@Override
		public void run() {
			while (count < sentence.length) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (sentence) {
					if (count >= sentence.length) {
						break;
					}
					System.out.println("Thread: "
							+ Thread.currentThread().getName() + " printed : "
							+ sentence[count++]);
					latch.countDown();
				}
			}
			
			System.out.println("Exiting Thread : "
					+ Thread.currentThread().getName());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] sentence = { "I", "am", "Pratik", "I", "am", "Pratik" };
			
		CountDownLatch latch = new CountDownLatch(sentence.length);
		PrintStrings printStrings = new PrintStrings();
		Thread printerThread1 = new Thread(printStrings.new PrinterThread(sentence, latch));
		Thread printerThread2 = new Thread(printStrings.new PrinterThread(sentence, latch));
		printerThread1.start();
		printerThread2.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
