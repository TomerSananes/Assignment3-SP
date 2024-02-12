//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_2;
import java.util.Random;

public class GamePlay {
    private boolean coin_available;
    private int rounds_counter;

    public synchronized void makeCoinAvail(boolean val) {
        this.coin_available = val; //set if the coin available
        if (val) { //if the coin is now available, wake up the threads that are waiting
            notifyAll();
        }
    }

    public synchronized boolean flipCoin() throws InterruptedException {
        while (!coin_available) {   //if the coin is not available-thread waits
            System.out.println(Thread.currentThread().getName() + " is waiting for coin");
            wait();
        }
        //if the coin is available then make a turn and flip the coin
        System.out.println(Thread.currentThread().getName() + " is flipping coin");
        this.coin_available = false; //after flipping now the coin is not available
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
