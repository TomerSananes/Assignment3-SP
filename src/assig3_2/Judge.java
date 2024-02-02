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
                System.out.println(Thread.currentThread().getName()+" enter to sleep 1 sec");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" after sleep 1 sec");

                // Make the coin available for half a second
                System.out.println(Thread.currentThread().getName()+" enter to sleep 0.5 sec");
                gamePlay.makeCoinAvail(true);
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+" after sleep 0.5 sec");

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

