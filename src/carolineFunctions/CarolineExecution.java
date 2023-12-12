package carolineFunctions;

public class CarolineExecution {
	
	private static int numPhilosophers = 5;
	private static Object[] forks = new Object[numPhilosophers];
	private static Philosopher[] philosophers = new Philosopher[numPhilosophers];
	
	public static void carolineStart() {		
		for(int i = 0; i < numPhilosophers; i++) {
			forks[i] = new Object();
		}
		
		for(int i = 0; i < numPhilosophers; i++) {
			philosophers[i] = new Philosopher(numPhilosophers, i);
		}
		
		for(Philosopher philosopher : philosophers) {
			philosopher.start();
		}
	}
	
	public static void carolineStop() {
		for(Philosopher philosopher : philosophers) {
			philosopher.interrupt();
		}
	}

	public static Object[] getForks() {
		return forks;
	}

}
