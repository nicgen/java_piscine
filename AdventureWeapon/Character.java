import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private final Weapon weapon;
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth, Weapon weapon){
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    protected  void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public String getName(){
        return this.name;
    }


    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public String toString(){
        if (this.currentHealth == 0){
            return String.format("%s : KO", this.name);
        }
        return String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
    }

    public abstract void takeDamage(int n);

    public abstract void attack(Character player);

    public static String printStatus(){
        StringBuilder output = new StringBuilder();
        if (!Character.allCharacters.isEmpty()){
            output.append("------------------------------------------\n");
            output.append("Characters currently fighting :\n");
            for (Character character : Character.allCharacters) {
                output.append(String.format(" - %s\n", character.toString()));
            }
            output.append("------------------------------------------\n");
        }else{
            output.append("------------------------------------------\n");
            output.append("Nobody's fighting right now !\n");
            output.append("------------------------------------------\n");
        }
        return output.toString();
    }

    public static Character fight(Character player1, Character player2){

        while(player2.currentHealth > 0 && player1.currentHealth > 0){
            player1.attack(player2);
            if (player2.currentHealth <= 0){
                return player1;
            }

            player2.attack(player1);
            if (player1.currentHealth <= 0){
                return player2;
            }
        }
        return null;
    }
}