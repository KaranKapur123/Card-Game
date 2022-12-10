public class Cards {
    String Card_Name;
    int Card_Toughness;
    int Card_Power;
    int Card_Mana_Cost;
    boolean Tapped;
    boolean FirstTurn=true;
    boolean Attacking;
    int BlockingCardNumber;
    boolean Blocking;
    Cards(String Card_Name, int Card_Toughness,int Card_Power, int Card_Mana_Cost){
        this.Card_Name=Card_Name;
        this.Card_Toughness=Card_Toughness;
        this.Card_Power=Card_Power;
        this.Card_Mana_Cost=Card_Mana_Cost;
    }
}