package assig3_2;

public class Gamer {
    private int goodFlipsCounter;
    GamePlay gamePlay;

    public Gamer(GamePlay gamePlay){
        this.gamePlay=gamePlay;
    }

    public synchronized void play() throws InterruptedException {
        while(!Thread.interrupted() && gamePlay.getNumOfRounds() <=10 ){
            if(gamePlay.flipCoin()){
                goodFlipsCounter++;
                Thread.sleep(1000);
            }
        }
    }

    public int getScore(){
        return goodFlipsCounter;
    }
}
