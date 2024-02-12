package assig3_1;

import java.util.concurrent.Semaphore;

public class RunnableC implements Runnable {

    private Semaphore semaphoreA;
    private Semaphore semaphoreC;

    public RunnableC(Semaphore semaphoreA, Semaphore semaphoreC) {
    this.semaphoreA=semaphoreA;
    this.semaphoreC=semaphoreC;
    }

    @Override
    public void run() {
        while (true){
            try {
                semaphoreC.acquire(); //C makes his turn
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("C");
            semaphoreA.release(); //release A so it will work after C
        }
    }
}
