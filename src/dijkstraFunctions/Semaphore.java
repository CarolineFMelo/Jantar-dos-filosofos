package dijkstraFunctions;

public class Semaphore {

	private int num;

	public Semaphore(int numMaxThreads) {
		this.num = numMaxThreads;
	}

	public synchronized void down() {
		synchronized(this) {
			try {
				while(num == 0) {
					this.wait();
				}
				num--;
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public synchronized void up() {
		synchronized(this) {
			this.num++;
			notifyAll();
		}
	}

}
