package assig3_2;

public class Gamer extends Thread{
    private int goodFlipsCounter;
    GamePlay gamePlay;

    public Gamer(GamePlay gamePlay){
        this.gamePlay=gamePlay;
    }

    public synchronized void play()  {
        int i=0;
        while(!Thread.interrupted() && gamePlay.getNumOfRounds() <10 ){
            i++;
            System.out.println(Thread.currentThread().getName()+" enter to play "+ i+" time");
            try {
                System.out.println(Thread.currentThread().getName()+" about to flip a coin");
                if(gamePlay.flipCoin()){
                    System.out.println(Thread.currentThread().getName()+" flip a coin");
                    goodFlipsCounter++;
                    System.out.println(Thread.currentThread().getName()+" about to sleep");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" after to sleep");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized int getScore(){
        return goodFlipsCounter;
    }

    public void run() {
        play();
    }
}
