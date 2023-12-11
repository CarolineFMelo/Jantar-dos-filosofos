package carolineFunctions;

public class CarolineExecution {

	static int numPhilosophers = 5;
	static Object[] forks = new Object[numPhilosophers];
	
	public void carolineStart() {
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
