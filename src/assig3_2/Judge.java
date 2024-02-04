package assig3_2;

public class Judge extends Thread{
    private GamePlay game;

    public Judge (GamePlay game){
        this.game = game;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                game.steCoinAvailable(false);
                Thread.sleep(1000);
                game.steCoinAvailable(true);
                Thread.sleep(500);
            }catch (Exception e){
                break;
            }
        }
    }
}
