public class Players {
    String Name;
    Healths Health;
    Decks Deck;
    Hands Hand;
    Battlefields Battlefield;

    Players(String PlayerName) {
        Decks PlayerDeck=new Decks();
        Hands PlayerHand=new Hands();
        Battlefields PlayerBattlefield=new Battlefields();
        Healths PlayerHealth=new Healths();
        PlayerHealth.SetHealth(20);
        this.Name = PlayerName;
        this.Health = PlayerHealth;
        this.Deck = PlayerDeck;
        this.Hand = PlayerHand;
        this.Battlefield = PlayerBattlefield;
    }

    public Healths LooseHealth(int HealthLost) {
        Health.LoseHealth(HealthLost);
        return Health;
    }

    public Healths GainHealth(int HealthGained) {
        Health.GainHealth(HealthGained);
        return Health;
    }
    public void PrintStats(){
        System.out.println();
        System.out.println("----------------------------PLAYER: "+Name+" ----------------------------");
        Health.PrintHealth();
        Hand.PrintCards();
        Battlefield.PrintCards();
    }
    public void PrintName(){
        System.out.println(Name);
    }
    public void PrintHealth(){
        System.out.println(Health);
    }
    public void PrintDeck() { Deck.PrintCards();
    }
    public void PrintHand(){
        Hand.PrintCards();
    }
    public void DrawCard(){
        Hand.AddFirstDeckCardToLast(Deck);
        Deck.RemoveTopCard();
    }
    public void DrawCards(int NumberofCards){
        for(int i=0;i<NumberofCards;i++) {
            Hand.AddFirstDeckCardToLast(Deck);
            Deck.RemoveTopCard();
        }
    }
    public void PlayCard(int Index){
        Battlefield.AddCardToBattlefield(Index, Hand);
        System.out.println(Hand.PlayerHand.get(Index-1).Card_Name+" has been put on the battlefield");
        Hand.RemoveCard(Index);
    }
    public Decks Initialize(){
        Deck.AddCards();
        Deck.Shuffle();
        Health.Initialize();
        return Deck;
    }
}