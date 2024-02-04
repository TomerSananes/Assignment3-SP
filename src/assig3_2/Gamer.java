package assig3_2;

public class Gamer extends Thread{
    private int goodFlipCounter;
    private GamePlay game;

    public Gamer(GamePlay game){
        this.game = game;
    }

    public void play(){
        while(!Thread.interrupted() && game.getNumOfRounds()<10) {
            if(game.flipCoin()){
                goodFlipCounter++;
            }
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }

    public int getScore(){
        return goodFlipCounter;
    }

    @Override
    public void run() {
        play();
    }
}
