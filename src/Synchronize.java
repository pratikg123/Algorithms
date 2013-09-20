
public class Synchronize {

	Object lock1 = new Object();
	Object lock2 = new Object();

	public void f1() throws InterruptedException {
		synchronized (lock1) {
			Thread.sleep(10000);
			synchronized (lock2) {

			}

		}
		System.out.println("Executed f1");
	}

	public void f2() throws InterruptedException {
		
		synchronized (lock2) {
			synchronized (lock1) {

			}

		}
		System.out.println("Executed f2");
	}

	public static void main(String[] args) {

		final Synchronize syn = new Synchronize();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					syn.f1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					syn.f2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();

	}

}
