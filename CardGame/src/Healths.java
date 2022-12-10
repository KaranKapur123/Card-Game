public class Healths {
    int PlayerHealth;
    public int GainHealth(int HealthGained){
        PlayerHealth=PlayerHealth+HealthGained;
        return PlayerHealth;
    }
    public int LoseHealth(int HealthLost){
        PlayerHealth=PlayerHealth-HealthLost;
        return PlayerHealth;
    }
    public int SetHealth(int health){
        PlayerHealth=health;
        return PlayerHealth;
    }
    public int Initialize(){
        PlayerHealth=20;
        return PlayerHealth;
    }
    void PrintHealth(){
        System.out.println("HEALTH:");
        System.out.println(PlayerHealth);
    }
}