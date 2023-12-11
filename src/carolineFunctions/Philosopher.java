package carolineFunctions;

import java.util.ArrayList;
import java.util.List;

public class Philosopher extends Thread {

	private int idThread, leftFork, rightFork, contEat = 0;
	private long start = System.currentTimeMillis();
	private long timeWithoutEating = 0;
	private long timeAux = System.currentTimeMillis();
	private long thinkingEatingTime = 0;
	private long subAux = 0;
	private List<List<Long>> timeData;

	public Philosopher(int num, int id) {
        this.idThread = id;
        this.leftFork = id;
        this.rightFork = (id + 1) % num;
        this.timeData = new ArrayList<>(num);
		
        for(int i = 0; i < num; i++) {
        	timeData.add(new ArrayList<>());
        }
    }

	@Override
	public void run() {
		while(true) {
			//limits execution time in milliseconds for tests
			if(System.currentTimeMillis() - start > 1000) {
                break;
            }
			
			//philosopher's life cycle
			think();
			
			//guarantees an order to avoid deadlock
            int smallFork = Math.min(leftFork, rightFork);
            int bigFork = Math.max(leftFork, rightFork);
			
			synchronized(CarolineExecution.getForks()[smallFork]) {
				synchronized(CarolineExecution.getForks()[bigFork]) {
					eat();
				}
			}
			timeWithoutEating = System.currentTimeMillis();
		}
		
		// print average waiting time
		//System.out.println("Tempo de espera do filosofo " + (idThread + 1));
		long sum = 0;
		for(List<Long> tD : timeData) {
			for(Long time : tD) {
				//System.out.print(time + "\n");
				sum += time;
			}
		}
		System.out.println("Tempo medio de espera do filosofo " + (idThread + 1) + ": " + (sum / contEat));

		// print maximum waiting time
		long max = Long.MIN_VALUE;
		for(List<Long> tD : timeData) {
			for(Long time : tD) {
				if (time > max) {
					max = time;
				}
			}
		}
		System.out.println("Tempo maximo de espera do filosofo " + (idThread + 1) + ": " + max);
	}

	private void think() {
		System.out.println(idThread + 1 + " esta pensando.");
		try {
			//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
            Thread.sleep((long) (Math.random() * 400 + 100));
            
            //beginning of the time between thinking and eating
			thinkingEatingTime = System.currentTimeMillis();
            
            //time without eating
            timeWithoutEating = System.currentTimeMillis() - timeAux;
            System.out.println(idThread + " nao come a " + timeWithoutEating + " milisegundos.");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void eat() {
		System.out.println(idThread + 1 + " esta comendo.");
		try {
			//waiting time between thinking and eating
        	subAux = System.currentTimeMillis() - thinkingEatingTime;
        	timeData.get(idThread).add(subAux);
			
			//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
			Thread.sleep((long) (Math.random() * 400 + 100));
            
			//reset time counter without eating
            timeAux = System.currentTimeMillis();
			
            //counter of times eaten
            contEat++;
            System.out.println(idThread + 1 + " comeu " + contEat + " vezes.");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
