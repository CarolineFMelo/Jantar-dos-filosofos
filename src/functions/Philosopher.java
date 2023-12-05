package functions;

public class Philosopher extends Thread {
	
	private int idThread;
	private Semaphore leftFork;
	private Semaphore rightFork;
	
	public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
		this.idThread = id;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	@Override
	public void run() {
		while(true) {
			//philosopher's life cycle
            think();
            leftFork.down();
            rightFork.down();
            eat();
            leftFork.up();
            rightFork.up();
        }
	}
	
	public void think() {
		System.out.println(idThread + " esta pensando.");
		try {
			//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
			Thread.sleep((long) (Math.random() * 100 + 500));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void eat() {
		System.out.println(idThread + " esta comendo.");
        try {
        	//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
            Thread.sleep((long) (Math.random() * 100 + 500));
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
	}

}
