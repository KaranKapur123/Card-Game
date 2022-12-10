import java.util.ArrayList;

public class Hands {
    ArrayList<Cards> PlayerHand=new ArrayList<Cards>();
    ArrayList<Cards> AddFirstDeckCardToLast(Decks PlayerDeck) {
        PlayerHand.add(PlayerDeck.GetTopCard());
        return PlayerHand;
    }

    public void PrintCards() {
        System.out.println("HAND:");
        for (int i = 0; PlayerHand.size() > i; i++) {
            System.out.println(i+1 + ") " + PlayerHand.get(i).Card_Name+" ("+PlayerHand.get(i).Card_Power+"/"+PlayerHand.get(i).Card_Toughness+")");
        }
        System.out.println();
    }
    ArrayList<Cards> RemoveCard(int CardNumber){
        CardNumber = CardNumber -1;
        PlayerHand.remove(CardNumber);
        return PlayerHand;
    }
}