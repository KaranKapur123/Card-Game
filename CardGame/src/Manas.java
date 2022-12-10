public class Manas {
    int Mana=0;
    Manas(){
        this.Mana=Mana;
    }
    void Add1Mana(){
        Mana=Mana+1;
    }
    void PrintMana() {
        System.out.println("MANA: " + Mana);
    }
    void SetMana(int ManaInput){
        Mana=ManaInput;
    }
}