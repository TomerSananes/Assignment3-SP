package assig3_1;

import java.util.concurrent.Semaphore;

public class RunnableA implements Runnable{
private Semaphore semaphoreA;
private Semaphore semaphoreB; //to wake up B

    public RunnableA(Semaphore semaphoreA, Semaphore semaphoreB) {
        this.semaphoreA=semaphoreA;
        this.semaphoreB=semaphoreB;
    }

    @Override
    public void run() {
        while(true){  //while(!interrupted)---another option and then in main do interrupt
            try {
                semaphoreA.acquire();  //default is 1
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("A");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphoreB.release(); //add "coin" to B, now B has 1
        }
    }
}
