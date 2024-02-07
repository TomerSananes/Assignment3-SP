package assig3_1;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreA=new Semaphore(1);
        Semaphore semaphoreB=new Semaphore(0);
        Semaphore semaphoreC=new Semaphore(0);

        RunnableA runnableA=new RunnableA(semaphoreA,semaphoreB);
        RunnableB runnableB=new RunnableB(semaphoreB,semaphoreC);
        RunnableC runnableC=new RunnableC(semaphoreA,semaphoreC);

        Thread t1=new Thread(runnableA);
        Thread t2=new Thread(runnableB);
        Thread t3=new Thread(runnableC);

        t1.start();
        t2.start();
        t3.start();

    }


}
