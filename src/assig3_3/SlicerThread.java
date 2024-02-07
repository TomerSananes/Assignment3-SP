package assig3_3;

public class SlicerThread extends Thread {

    private final SlicerMachine slicerMachine;

    public SlicerThread(SlicerMachine slicerMachine) {
        this.slicerMachine = slicerMachine;
    }

    public void cut() {
        synchronized (slicerMachine) {
            while (!slicerMachine.finishSlicerThread) {
                while (slicerMachine.numOfCucumbers != slicerMachine.cucumbersNeededForOneSalad ||
                        slicerMachine.numOfTomatoes != slicerMachine.tomatoesNeededForOneSalad) {
                    try {
                        slicerMachine.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                slicerMachine.sliceVegetables();
                slicerMachine.notifyAll();
            }
        }
    }

    public void run() {
        cut();
    }
}
