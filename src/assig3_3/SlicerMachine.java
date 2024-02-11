//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_3;

public class SlicerMachine {
	
	private int numOfCucumbers = 0;
	private int numOfTomatoes = 0;
	private int numOfPreparedSalads = 0;
	
	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;
	
	// add one cucumber into the slicer chamber
	public synchronized void addOneCucumber() {
		while(numOfCucumbers == cucumbersNeededForOneSalad){
			try {
				wait();
			}catch (InterruptedException e){
				Thread.currentThread().interrupt();
				break;
			}
		}
		if (numOfCucumbers < cucumbersNeededForOneSalad) {
			System.out.println("adding one cucumber to the machine");
			numOfCucumbers++;
		}
		notifyAll();
	}

	// add one tomato into the slicer chamber
	public synchronized void addOneTomato() {
		while(numOfTomatoes == tomatoesNeededForOneSalad){
			try {
				wait();
			}catch (InterruptedException e){
				Thread.currentThread().interrupt();
				break;
			}
		}
		if (numOfTomatoes < tomatoesNeededForOneSalad) {
			System.out.println("adding one tomato to the machine");
			numOfTomatoes++;
		}
		notifyAll();
	}
	
	// if there are enough vegetables in the slicer
	// chamber, make another salad
	public synchronized void sliceVegetables() {
		while ((numOfCucumbers < cucumbersNeededForOneSalad) || (numOfTomatoes < tomatoesNeededForOneSalad)) {
			try {
				wait();
			}catch (InterruptedException e){
				break;
			}
		}
		makeNewSalad();
	}

	//private method called from sliceVegetables method
	//preparing one salad, and update the variables
	private void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
		notifyAll();
	}	
	
	public synchronized int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}
}
