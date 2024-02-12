//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_2;

public class Gamer extends Thread {
    private int goodFlipsCounter;
    GamePlay gamePlay;

    public Gamer(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    public synchronized void play() {
        int i = 0;
        while (!Thread.interrupted() && gamePlay.getNumOfRounds() < 10) {
            i++;
            try {
                if (gamePlay.flipCoin()) { //if flip a coin successfully, add one to good flips
                    goodFlipsCounter++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized int getScore() {
        return goodFlipsCounter;
    }

    public void run() {
        play();
    }
}
