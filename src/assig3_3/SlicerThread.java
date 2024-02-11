//Roni Kimhi 315298182, Tomer Sananes 207698986

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
        //run the method sliceVegetables() while there is more salads to prepare
        while(machine.getNumOfPreparedSalads()!= saladNum)
            machine.sliceVegetables();
    }

}
