import java.util.ArrayList;

public class Battlefields {

    ArrayList<Cards> PlayerBattlefield = new ArrayList<Cards>();

    public ArrayList<Cards> AddCardToBattlefield(int CardNumber, Hands PlayerHand) {
        CardNumber = CardNumber - 1;
        PlayerBattlefield.add(PlayerHand.PlayerHand.get(CardNumber));
        return PlayerBattlefield;
    }

    public void PrintCards() {
        System.out.println("BATTLEFIELD:");
        for (int i = 0; PlayerBattlefield.size() > i; i++) {
            if (PlayerBattlefield.get(i).Attacking == true){
                System.out.println(i + 1 + ") " + PlayerBattlefield.get(i).Card_Name+" ("+PlayerBattlefield.get(i).Card_Power+"/"+PlayerBattlefield.get(i).Card_Toughness+")"+"   (Attacking)");
            }else {
                System.out.println(i + 1 + ") "+PlayerBattlefield.get(i).Card_Name+" ("+PlayerBattlefield.get(i).Card_Power+"/"+PlayerBattlefield.get(i).Card_Toughness+")");
            }
        }
        System.out.println();
    }
}