package assig3_3;

public class CucumbersThread extends Thread {
    private final SlicerMachine slicerMachine;
    private int neededCucumbers;

    public CucumbersThread(SlicerMachine slicerMachine) {
        this.slicerMachine = slicerMachine;
        this.neededCucumbers = slicerMachine.cucumbersNeededForOneSalad * slicerMachine.numOfWantedSalads;
    }

    public void addCucumber() {
        synchronized (slicerMachine) {
            while (!slicerMachine.finishSlicerThread) {
                while (slicerMachine.numOfCucumbers >= slicerMachine.cucumbersNeededForOneSalad) {
                    try {
                        slicerMachine.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                slicerMachine.addOneCucumber();
                if (slicerMachine.numOfCucumbers % slicerMachine.cucumbersNeededForOneSalad == 0) {
                    slicerMachine.notifyAll();
                }
            }
        }
    }

    public void run() {
        addCucumber();
    }
}
