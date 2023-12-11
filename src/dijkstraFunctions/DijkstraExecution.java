package dijkstraFunctions;

public class DijkstraExecution {
	
	public void dijkstraStart() {
		int numPhilosophers = 5;
		Semaphore[] forks = new Semaphore[numPhilosophers];
		Philosopher[] philosophers = new Philosopher[numPhilosophers];

		for(int i = 0; i < numPhilosophers; i++) {
			forks[i] = new Semaphore(1);
		}

		for(int j = 0; j < numPhilosophers; j++) {
			philosophers[j] = new Philosopher(numPhilosophers, j + 1, forks[j], forks[(j + 1) % numPhilosophers]);
		}

		for(Philosopher philosopher:philosophers) {
			philosopher.start();
		}
	}
	
}
