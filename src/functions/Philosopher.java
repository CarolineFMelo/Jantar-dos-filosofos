package functions;

import java.util.ArrayList;
import java.util.List;

public class Philosopher extends Thread {
	
	private int idThread;
	private Semaphore leftFork;
	private Semaphore rightFork;
	private int contEat = 0;
	private long timeWithoutEating = 0;
	private long thinkingEatingTime = 0;
	private long start = System.currentTimeMillis();
	private long subAux = 0;
	private long timeAux = System.currentTimeMillis();
	private List<List<Long>> timeData;
	
	public Philosopher(int num, int id, Semaphore leftFork, Semaphore rightFork) {
		this.idThread = id;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.timeData = new ArrayList<>(num);
		
        for (int i = 0; i < num; i++) {
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
            leftFork.down();
            rightFork.down();
            eat();
            leftFork.up();
            rightFork.up();
            timeWithoutEating = System.currentTimeMillis();
        }
	}
	
	public void think() {
		System.out.println(idThread + " esta pensando.");
		try {
			//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
			Thread.sleep((long) (Math.random() * 100 + 500));
			
			//beginning of the time between thinking and eating
			thinkingEatingTime = System.currentTimeMillis();
			
			//time without eating
			timeWithoutEating = System.currentTimeMillis() - timeAux;
            System.out.println(idThread + " nao come a " + timeWithoutEating + " milisegundos.");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void eat() {
		System.out.println(idThread + " esta comendo.");
        try {
        	//waiting time between thinking and eating
        	subAux = System.currentTimeMillis() - thinkingEatingTime;
        	timeData.get(idThread - 1).add(subAux);
        	
        	//generates a random number between 100 and 500 milliseconds (0.1 to 0.5 seconds)
            Thread.sleep((long) (Math.random() * 100 + 500));
            
            //reset time counter without eating
            timeAux = System.currentTimeMillis();
            
            //counter of times eaten
            contEat++;
            System.out.println(idThread + " comeu " + contEat + " vezes.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
	}

	//get value: timeDate.get(linha).get(indice);
	
}
