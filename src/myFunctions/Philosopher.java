package myFunctions;

public class Philosopher extends Thread {

	private int idThread;
	private int leftFork;
	private int rightFork;
	private int contEat = 0;
	private long start = System.currentTimeMillis();

	public Philosopher(int num, int id) {
        this.idThread = id;
        this.leftFork = id;
        this.rightFork = (id + 1) % num;
    }

	@Override
	public void run() {
		while(true) {
			//limits execution time in milliseconds for tests
			if(System.currentTimeMillis() - start > 2000) {
                break;
            }
			
			//philosopher's life cycle
			think();
			
			//guarantees an order to avoid deadlock
            int smallFork = Math.min(leftFork, rightFork);
            int bigFork = Math.max(leftFork, rightFork);
			
			synchronized(MyExecution.getForks()[smallFork]) {
				synchronized(MyExecution.getForks()[bigFork]) {
					eat();
				}
			}
		}
	}

	private void think() {
		System.out.println(idThread + 1 + " esta pensando.");
		try {
			//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
            Thread.sleep((long) (Math.random() * 100 + 500));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void eat() {
		System.out.println(idThread + 1 + " esta comendo.");
		try {
			//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
			Thread.sleep((long) (Math.random() * 100 + 500));
            
            //counter of times eaten
            contEat++;
            System.out.println(idThread + 1 + " comeu " + contEat + " vezes.");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
