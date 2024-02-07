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
                semaphoreC.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("C");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphoreA.release();

        }
    }

//if B can run 0 times
//    public void run() {
//        while(true){  //while(!interrupted)---another option and then in main do interrupt
//            try {
//                semaphoreB.acquire();  //default is 1
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("B");
//            semaphoreA.release(); //add "coin" to B
//        }
//    }
}
