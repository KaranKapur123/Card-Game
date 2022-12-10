import java.util.ArrayList;
import java.util.Collections;

public class Decks {
   ArrayList<Cards> PlayerDeck=new ArrayList<Cards>();
    ArrayList<Cards> AddCards() {
      Cards Aatrox = new Cards("Aatrox", 8, 5, 5);
      Cards Ahri = new Cards("Ahri", 2, 3, 2);
      Cards Akali = new Cards("Akali", 5, 6, 4);
      Cards Akshan = new Cards("Akshan", 2, 2, 2);
      Cards Alistar = new Cards("Alistar", 3, 1, 1);
        Cards Amumu=new Cards("Amumu",6,2,2);
        Cards Anivia=new Cards("Anivia",2,3,2);
        Cards Annie=new Cards("Annie",5,4,2);
        Cards Aphelios=new Cards("Aphelios",2,6,5);
        Cards Ashe=new Cards("Ashe",2,4,4);
        Cards AurelionSol=new Cards("AurelionSol",4,2,2);
        Cards Azir=new Cards("Azir",5,6,6);
        Cards Bard=new Cards("Bard",5,2,1);
        Cards BelVeth=new Cards("BelVeth",5,4,3);
        Cards Blitzcrank=new Cards("Blitzcrank",4,4,2);
        Cards Brand=new Cards("Brand",2,6,4);
        Cards Braum=new Cards("Braum",8,2,1);
        Cards Caitlyn=new Cards("Caitlyn",2,6,6);
        Cards Camille=new Cards("Camille",6,7,6);
        Cards Cassiopeia=new Cards("Cassiopeia",4,6,5);
        Cards ChoGath=new Cards("ChoGath",8,4,5);
        Cards Corki=new Cards("Corki",5,8,7);
        Cards Darius=new Cards("Darius",6,7,6);
        Cards Draven=new Cards("Draven",2,7,6);
        Cards Ekko=new Cards("Ekko",5,5,4);
        Cards Elise=new Cards("Elise",4,4,4);
        Cards Evelynn=new Cards("Evelynn",3,6,4);
        Cards Ezreal=new Cards("Ezreal",3,5,3);
        Cards Fiddlesticks=new Cards("Fiddlesticks",2,7,5);
        Cards Fiora=new Cards("Fiora",5,6,5);
        Cards Fizz=new Cards("Fizz",3,7,5);
        Cards Galio=new Cards("Galio",6,5,4);
        Cards Gangplank=new Cards("Gangplank",5,7,5);
        Cards Garen=new Cards("Garen",8,6,7);
        Cards Gnar=new Cards("Gnar",8,5,6);
        Cards Gragas=new Cards("Gragas",7,5,5);
        Cards Graves=new Cards("Graves",5,7,5);
        Cards Gwen=new Cards("Gwen",5,7,6);
        Cards Hecarim=new Cards("Hecarim",5,7,5);
        Cards Heimerdinger=new Cards("Heimerdinger",3,6,5);
        Cards Illaoi=new Cards("Illaoi",8,5,6);
        Cards Irelia=new Cards("Irelia",5,7,5);
        Cards Ivern=new Cards("Ivern",7,3,4);
        Cards Janna=new Cards("Janna",2,2,1);
        Cards JarvanIV=new Cards("JarvanIV",6,4,3);
        PlayerDeck.add(Aatrox);
      PlayerDeck.add(Ahri);
      PlayerDeck.add(Akali);
      PlayerDeck.add(Akshan);
      PlayerDeck.add(Alistar);
        PlayerDeck.add(Amumu);
        PlayerDeck.add(Anivia);
        PlayerDeck.add(Annie);
        PlayerDeck.add(Aphelios);
        PlayerDeck.add(Ashe);
        PlayerDeck.add(AurelionSol);
        PlayerDeck.add(Azir);
        PlayerDeck.add(Bard);
        PlayerDeck.add(BelVeth);
        PlayerDeck.add(Blitzcrank);
        PlayerDeck.add(Brand);
        PlayerDeck.add(Braum);
        PlayerDeck.add(Caitlyn);
        PlayerDeck.add(Camille);
        PlayerDeck.add(Cassiopeia);
        PlayerDeck.add(ChoGath);
        PlayerDeck.add(Corki);
        PlayerDeck.add(Darius);
        PlayerDeck.add(Draven);
        PlayerDeck.add(Ekko);
        PlayerDeck.add(Elise);
        PlayerDeck.add(Evelynn);
        PlayerDeck.add(Ezreal);
        PlayerDeck.add(Fiddlesticks);
        PlayerDeck.add(Fiora);
        PlayerDeck.add(Fizz);
        PlayerDeck.add(Galio);
        PlayerDeck.add(Gangplank);
        PlayerDeck.add(Garen);
        PlayerDeck.add(Gnar);
        PlayerDeck.add(Gragas);
        PlayerDeck.add(Graves);
        PlayerDeck.add(Gwen);
        PlayerDeck.add(Hecarim);
        PlayerDeck.add(Heimerdinger);
        PlayerDeck.add(Illaoi);
        PlayerDeck.add(Irelia);
        PlayerDeck.add(Ivern);
        PlayerDeck.add(Janna);
        PlayerDeck.add(JarvanIV);

        System.out.println("Deck Initialized");
      System.out.println();
      return PlayerDeck;
   }
    public ArrayList<Cards> AddCardToDeck(Cards CardToBeAdded) {
        PlayerDeck.add(CardToBeAdded);
        return PlayerDeck;
    }
    public ArrayList<Cards> Shuffle() {
      Collections.shuffle(PlayerDeck);
      return PlayerDeck;
   }
   public void PrintCards() {
       System.out.println("DECK:");
       for (int i=0;PlayerDeck.size()>i;i++) {
           System.out.println(i+1 + ") " + PlayerDeck.get(i).Card_Name+" ("+PlayerDeck.get(i).Card_Power+"/"+PlayerDeck.get(i).Card_Toughness+")");
       }
       System.out.println();}
   public ArrayList<Cards> RemoveTopCard(){
      PlayerDeck.remove(0);
      return PlayerDeck;
   }
    public Cards GetTopCard(){
        return PlayerDeck.get(0);
    }
    public ArrayList<Cards> add(Cards card){
        PlayerDeck.add(card);
        return PlayerDeck;
    }

}