//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_3;

public class TomatoesThread extends Thread {

    private SlicerMachine machine;

    public TomatoesThread(SlicerMachine machine){
        this.machine=machine;
    }

    @Override
    public void run() {
        //run the method addOneTomato() while the thread is not interrupted
        while(!isInterrupted()) {
            machine.addOneTomato();
        }
    }

}
