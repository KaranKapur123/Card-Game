public class Main{
    public static void main(String[] args) {
        GameParts Game=new GameParts();
        Game.Initialization();
        Game.Mana.SetMana(5);
        boolean GameRunning=true;
        Game.Players.get(0).DrawCards(7);
        Game.Players.get(1).DrawCards(7);
        Game.Player1Turn();
        Game.Player2Turn();
        while (GameRunning==true){
            if(GameRunning==true) {
                Game.Player1Turn();
                Game.Player1Attacking();
                Game.Player2Blocking();
                GameRunning = Game.ContinueGame();
            }
            if(GameRunning==true) {
                Game.Player2Turn();
                Game.Player2Attacking();
                Game.Player1Blocking();
                GameRunning = Game.ContinueGame();
            }
        }
        System.out.println("Game has ended");
    }
}