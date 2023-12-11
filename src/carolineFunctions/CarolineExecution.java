package carolineFunctions;

public class CarolineExecution {

	private static int numPhilosophers = 5;
	private static Object[] forks = new Object[numPhilosophers];
	
	public static void main(String[] args) {
		Philosopher[] filosofos = new Philosopher[numPhilosophers];
		
		for(int i = 0; i < numPhilosophers; i++) {
			forks[i] = new Object();
		}

		for(int i = 0; i < numPhilosophers; i++) {
			filosofos[i] = new Philosopher(numPhilosophers, i);
		}
		
		for(int i = 0; i < numPhilosophers; i++) {
			filosofos[i].start();
		}
	}

	public static Object[] getForks() {
		return forks;
	}

}
