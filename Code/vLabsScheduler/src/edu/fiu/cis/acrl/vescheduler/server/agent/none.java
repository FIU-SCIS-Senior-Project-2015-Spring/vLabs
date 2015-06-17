// A correct implementation of a producer and consumer.
class Q {
	int n;
	boolean valueSet = false;
	synchronized int get() {
		System.out.println("get - Inside! valueSet: " + valueSet);
		if(!valueSet) {
			try {
				System.out.println("get - before wait.");
				wait();
				System.out.println("get - after wait.");
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}

		System.out.println("get - n: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		System.out.println("put - Inside! valueSet: " + valueSet);
		if(valueSet) {
			try {
				System.out.println("put - before wait.");
				wait();
				System.out.println("put - after wait");
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}

		this.n = n;
		valueSet = true;
		System.out.println("put - n: " + n);
		notify();
	}
}

class Producer implements Runnable {
	Q q;
	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}
	public void run() {
		int i = 0;
		while(true) {
			System.out.println("Producer - before put.");
			q.put(i++);
			System.out.println("Producer - after put.");
		}
	}
}

class Consumer implements Runnable {
	Q q;
	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	public void run() {
		while(true) {
			System.out.println("Consumer - before get.");
			q.get();
			System.out.println("Consumer - after get.");
		}
	}
}

public class none {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}
}