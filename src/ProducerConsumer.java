import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(1);
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}

}

class Producer implements Runnable {

	BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> q) {
		queue = q;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String s = "" + new Random().nextInt(10000);
				
				queue.put(s);
				System.out.println("Produced : " + s);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {

	BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> q) {
		queue = q;
	}

	@Override
	public void run() {

		while (true) {
			try {
				System.out.println("Consuming : " + queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}