package assig3_3;

public class TomatoesThread extends Thread {
    private final SlicerMachine slicerMachine;
    private int neededTomato;


    public TomatoesThread(SlicerMachine slicerMachine) {
        this.slicerMachine = slicerMachine;
        this.neededTomato = slicerMachine.tomatoesNeededForOneSalad * slicerMachine.numOfWantedSalads;
    }

    public void addTomato() {
        synchronized (slicerMachine) {
            while (!slicerMachine.finishSlicerThread) {
                while (slicerMachine.numOfTomatoes >= slicerMachine.tomatoesNeededForOneSalad) {
                    try {
                        slicerMachine.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                slicerMachine.addOneTomato();
                if (slicerMachine.numOfTomatoes % slicerMachine.tomatoesNeededForOneSalad == 0) {
                    slicerMachine.notifyAll();
                }
            }
        }
    }


    public void run() {
        addTomato();
    }
}
