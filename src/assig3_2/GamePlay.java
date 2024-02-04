package assig3_2;

import java.util.Random;

public class GamePlay {
    public boolean coin_available_;
    private int rounds_counter_;

    synchronized public void makeCoinAvailable(boolean val){
        coin_available_= val;
        if(coin_available_){
            notifyAll();
        }
    }

    synchronized public boolean flipCoin(){
        while(!coin_available_) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for coin");
                wait();
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " is flipping coin");
        coin_available_ = false;
        rounds_counter_++;
        int result = new Random().nextInt(0,2);
        coin_available_= true;
        notifyAll();
        return result==1;
    }

    synchronized public int getNumOfRounds(){
        return rounds_counter_;
    }

    synchronized public void steCoinAvailable(boolean flag){
        coin_available_ = flag;
        if(coin_available_){
            notifyAll();
        }
    }
}
