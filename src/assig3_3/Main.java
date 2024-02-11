//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//user input
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		//create and run our threads
		SlicerMachine machine= new SlicerMachine();
		CucumbersThread tCucumbers = new CucumbersThread(machine);
		TomatoesThread tTomatoes = new TomatoesThread(machine);
		SlicerThread tSlicer = new SlicerThread(machine,numOfSaladsToPrepare);
		tCucumbers.start();
		tTomatoes.start();
		tSlicer.start();

		//wait until the threads finish and then print the winner
		try{
			tSlicer.join();
			tCucumbers.interrupt();
			tTomatoes.interrupt();
			tCucumbers.join();
			tTomatoes.join();
		}catch(Exception e){
			System.out.println("Error");
		}

		System.out.println("Done");
		scan.close();
	}
}
