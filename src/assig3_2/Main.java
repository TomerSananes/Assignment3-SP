//Roni Kimhi 315298182, Tomer Sananes 207698986

package assig3_2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GamePlay gamePlay=new GamePlay();
        Judge judge=new Judge(gamePlay);
        Gamer g1=new Gamer(gamePlay);
        Gamer g2=new Gamer(gamePlay);

        g1.start();
        g2.start();
        judge.start();

        g1.join();
        g2.join();
        judge.join();

        if(g1.getScore()> g2.getScore()){
            System.out.println("Player "+ g1.getName()+" wins with "+ g1.getScore()+" score! while player 2 has "+g2.getScore());
        }else if (g2.getScore()>g1.getScore()){
            System.out.println("Player "+ g2.getName()+" wins with "+ g2.getScore()+" score! while player 1 has "+g1.getScore());
        }else{
            System.out.println("There is a tie, both players finished with "+g1.getScore()+" score!");
        }
    }
}
