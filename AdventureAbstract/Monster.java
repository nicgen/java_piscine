public class Monster extends Character{

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString(){
        if (this.getCurrentHealth() == 0){
            return String.format("%s is a monster and is dead", this.getName());
        }
        return String.format("%s is a monster with %d HP", this.getName(), this.getCurrentHealth());
    }

    @Override
    public void takeDamage(int damage) {
        damage = (int) Math.floor(damage * 0.8);
        if (this.getCurrentHealth() - damage < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(this.getCurrentHealth() - damage);
        }
    }

    @Override
    public void attack(Character player){
        player.takeDamage(7);
    }
}