//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_3;

public class CucumbersThread extends Thread {
    private SlicerMachine machine;

    public CucumbersThread(SlicerMachine machine){
        this.machine=machine;
    }

    @Override
    public void run() {
        //run the method addOneCucumber() while the thread is not interrupted
        while(!isInterrupted()) {
            machine.addOneCucumber();
        }
    }
}
