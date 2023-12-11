package execution;

import java.util.Scanner;
import dijkstraFunctions.*;
import carolineFunctions.*;

public class ProgramExecution {
	
	public static void main(String args[]) {
		//ask the algorithm
		Scanner scn = new Scanner(System.in);
		System.out.println("Selecione o algoritmo:\n[1]Algoritmo Dijkstra\n[2]Algoritmo Caroline");
		String alg = scn.nextLine();scn.close();

		//run chosen algorithm
		switch(alg) {
			case "1":
				new DijkstraExecution().dijkstraStart();
				break;
			case "2":
				new CarolineExecution().carolineStart();
				break;
			default:
				System.out.println("Opcao invalida");
		}
	}
	
}
