//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_2;

public class Judge extends Thread{
    GamePlay gamePlay;

    public Judge(GamePlay gamePlay){
        this.gamePlay=gamePlay;
    }
    public void changeNotAvail() throws InterruptedException {
            while (!Thread.interrupted() && gamePlay.getNumOfRounds() <10) {
                // Make the coin unavailable for a second
                gamePlay.makeCoinAvail(false);
                Thread.sleep(1000);

                // Make the coin available for half a second
                gamePlay.makeCoinAvail(true);
                Thread.sleep(500);
            }
        }

    public void run() {
        try {
            changeNotAvail();
        } catch (InterruptedException e) {
            System.out.println("there was an Interruption");
        }
    }
}

