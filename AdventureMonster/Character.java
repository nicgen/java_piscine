import java.util.ArrayList;
import java.util.List;

public class Character {
    private static List<Character> allCharacters = new ArrayList<>();

    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        // Track every created character
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        currentHealth = Math.max(0, currentHealth - amount);
    }

    public void attack(Character target) {
        if (target == null) {
            return;
        }
        target.takeDamage(9);
    }

    public static String printStatus() {
        String border = "------------------------------------------";
        if (allCharacters.isEmpty()) {
            return border + "\nNobody's fighting right now !\n" + border + "\n";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(border).append("\n");
            sb.append("Characters currently fighting :\n");
            for (Character character : allCharacters) {
                sb.append(" - ").append(character.toString()).append("\n");
            }
            sb.append(border).append("\n");
            return sb.toString();
        }
    }

    public static Character fight(Character first, Character second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Characters must not be null");
        }
        if (first == second) {
            return first;
        }

        // If one is already KO, the other wins immediately
        if (first.currentHealth == 0) return second;
        if (second.currentHealth == 0) return first;

        while (first.currentHealth > 0 && second.currentHealth > 0) {
            // First attacks
            first.attack(second);
            if (second.currentHealth == 0) {
                return first;
            }

            // Second attacks
            second.attack(first);
            if (first.currentHealth == 0) {
                return second;
            }
        }

        // Fallback (shouldn't reach here due to checks above)
        return first.currentHealth > 0 ? first : second;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }
}