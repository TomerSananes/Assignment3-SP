package assig3_2;

public class Judge {
    GamePlay gamePlay;
    public void changeNotAvail() throws InterruptedException {
        while(!Thread.interrupted()){
            if(gamePlay.flipCoin()){
                Thread.sleep(500);
            }else{
                gamePlay.makeCoinAvail(true);
            }

        }
    }
}
