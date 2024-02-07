package assig3_3;

public class SlicerMachine {

    int numOfCucumbers = 0;
    int numOfTomatoes = 0;
    int numOfPreparedSalads = 0;
    final int numOfWantedSalads;
    boolean finishSlicerThread=false;

    final int cucumbersNeededForOneSalad = 3;
    final int tomatoesNeededForOneSalad = 2;

    public SlicerMachine(int numOfNeededSalads) {
        this.numOfWantedSalads = numOfNeededSalads;
    }

    // add one cucumber into the slicer chamber
    void addOneCucumber() {
        if (numOfCucumbers < cucumbersNeededForOneSalad) {
            System.out.println("adding one cucumber to the machine");
            numOfCucumbers++;
        }
    }

    // add one tomato into the slicer chamber
    void addOneTomato() {
        if (numOfTomatoes < tomatoesNeededForOneSalad) {
            System.out.println("adding one tomato to the machine");
            numOfTomatoes++;
        }
    }


    // if there are enough vegetables in the slicer
    // chamber, make another salad
    void sliceVegetables() {
        if ((numOfCucumbers >= cucumbersNeededForOneSalad) && (numOfTomatoes >= tomatoesNeededForOneSalad)) {
            makeNewSalad();
            if(numOfWantedSalads==numOfPreparedSalads){
                finishSlicerThread=true;
            }
        }
    }


    private void makeNewSalad() {
        System.out.println("== preparing one more salad ==");
        numOfPreparedSalads++;

        // update stock
        numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
        numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
    }

    synchronized int getNumOfPreparedSalads() {
        return numOfPreparedSalads;
    }
}
