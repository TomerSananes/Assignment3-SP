package assig3_2;

import java.util.Random;

public class GamePlay {
    private boolean coin_available;
    private int rounds_counter;

        public synchronized void makeCoinAvail(boolean val) {
        this.coin_available = val;
        if(val){
            notifyAll();
        }
    }


    public synchronized boolean flipCoin() throws InterruptedException {
        while (!coin_available) {
            System.out.println(Thread.currentThread().getName() + " is waiting for coin");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " is flipping coin");
        this.coin_available = false;
        this.rounds_counter++;
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        boolean returnResult = (randomNumber == 1);
        this.coin_available = true;
        notifyAll();

        return returnResult;
    }

    public synchronized int getNumOfRounds() {
        return this.rounds_counter;
    }


}
