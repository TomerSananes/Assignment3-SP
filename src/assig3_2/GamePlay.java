package assig3_2;

import java.util.Random;

public class GamePlay {
    private boolean coin_available;
    private int rounds_counter;

    public GamePlay() {
    }  //check on later if needed

    public void makeCoinAvail(boolean val) throws InterruptedException {
        this.coin_available = val;
        while (!coin_available) {
            wait();
        }
        if (val) {
            notifyAll();
        }
    }

    public synchronized boolean flipCoin() throws InterruptedException {
        boolean returnResult = false;
        while (!coin_available) {
            System.out.println("Thread- " + Thread.currentThread().getName() + " is waiting for coin");
            wait();
        }
        while (coin_available) { //don't know if to use while or if and where to put the notifyAll()
            notifyAll();
            System.out.println("Thread- " + Thread.currentThread().getName() + " is flipping coin");
            this.coin_available = false;
            this.rounds_counter++;
            Random random = new Random();
            int randomNumber = random.nextInt(2);
            if (randomNumber == 1) {
                returnResult = true;
            }
            this.coin_available = true;
            notifyAll();
        }
        return returnResult;
    }

    public int getNumOfRounds(){
        return this.rounds_counter;
    }


}
