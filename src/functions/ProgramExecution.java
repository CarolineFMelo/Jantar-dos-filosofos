package functions;

public class ProgramExecution {
	
	public static void main(String args[]) {
		int numPhilosophers = 5;
		Semaphore[] forks = new Semaphore[numPhilosophers];
		Philosopher[] philosophers = new Philosopher[numPhilosophers];
		
		for(int i = 0; i < numPhilosophers; i++) {
			forks[i] = new Semaphore(1);
		}
		
		for(int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i + 1, forks[i], forks[(i + 1) % numPhilosophers]);
        }
		
		for(Philosopher philosopher : philosophers) {
			philosopher.start();
	    }
	}
	
}
