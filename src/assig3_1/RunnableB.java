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
    public void run() {   //need to run at least 1 time
        while(true){  //while(!interrupted)---another option and then in main do interrupt
            try {
                semaphoreB.acquire();  //default is 1
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("B");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphoreC.release();
            while(semaphoreC.tryAcquire()){  //אם תפס C נתקע ו-B רץ
                System.out.println("B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                semaphoreC.release();
            }
        }
    }
}
