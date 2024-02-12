//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_1;

import java.util.concurrent.Semaphore;

public class RunnableA implements Runnable{
private Semaphore semaphoreA;
private Semaphore semaphoreB; //use to wake up B

    public RunnableA(Semaphore semaphoreA, Semaphore semaphoreB) {
        this.semaphoreA=semaphoreA;
        this.semaphoreB=semaphoreB;
    }

    @Override
    public void run() {
        while(true){
            try {
                semaphoreA.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("A");
            semaphoreB.release(); //allow B to work now
        }
    }
}
