package assig3_2;

public class Main {
    public static void main(String[] args) {
        GamePlay game = new GamePlay();
        Gamer t1 = new Gamer(game);
        Gamer t2 = new Gamer(game);
        Judge j = new Judge(game);
        j.start();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
            j.interrupt();
            j.join();
        }catch(Exception e){

        }
        if(t1.getScore()> t2.getScore()){
            System.out.println("player " + t1.getName() + " wins");
        }else if (t1.getScore()< t2.getScore()){
            System.out.println("player " + t2.getName() + " wins");
        }else{
            System.out.println("tie");
        }
    }
}
