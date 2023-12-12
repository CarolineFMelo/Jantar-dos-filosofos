package dijkstraFunctions;

public class DijkstraExecution {
	
	private static int numPhilosophers = 5;
	private static Semaphore[] forks = new Semaphore[numPhilosophers];
	private static Philosopher[] philosophers = new Philosopher[numPhilosophers];
	
	public static void dijkstraStart() {
		for(int i = 0; i < numPhilosophers; i++) {
			forks[i] = new Semaphore(1);
		}
		
		for(int j = 0; j < numPhilosophers; j++) {
			philosophers[j] = new Philosopher(numPhilosophers, j + 1, forks[j], forks[(j + 1) % numPhilosophers]);
		}

		for(Philosopher philosopher : philosophers) {
			philosopher.start();
		}
	}
	
	public static void dijkstraStop() {
		for(Philosopher philosopher : philosophers) {
			philosopher.interrupt();
		}
	}
}
