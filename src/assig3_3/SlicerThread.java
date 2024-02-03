package assig3_3;

public class SlicerThread extends Thread {

    private SlicerMachine machine;
    private int saladNum;

    public SlicerThread(SlicerMachine machine,int saladNum){
        this.machine=machine;
        this.saladNum = saladNum;
    }

    @Override
    public void run() {
        while(machine.getNumOfPreparedSalads()!= saladNum)
            machine.sliceVegetables();
    }

}
