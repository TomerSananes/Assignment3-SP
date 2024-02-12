//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_1;

import java.util.concurrent.Semaphore;

public class RunnableB implements Runnable{
    private Semaphore semaphoreB;
    private Semaphore semaphoreC;


    public RunnableB(Semaphore semaphoreB,Semaphore semaphoreC){
        this.semaphoreB=semaphoreB;
        this.semaphoreC=semaphoreC;
    }
    @Override
    public void run() {
        while(true){
            try {
                semaphoreB.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("B");
            semaphoreC.release(); //give C an option to work, B and C race on the turn
            while(semaphoreC.tryAcquire()){  //if C didn't catch his turn, B continue to work
                System.out.println("B");
                semaphoreC.release();
            }
        }
    }
}
