public class Sorcerer extends Character implements Healer {

    private final int healCapacity;
    public Sorcerer(String name, int maxHealth, int healCapacity){
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity(){
        return this.healCapacity;
    }

    @Override
    public void heal(Character character){
        if (this.healCapacity + character.getCurrentHealth() <= character.getMaxHealth() ){
            character.setCurrentHealth(this.healCapacity + character.getCurrentHealth());
        }else{
            character.setCurrentHealth(character.getMaxHealth());
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (this.getCurrentHealth() - damage < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(this.getCurrentHealth() - damage);
        }
    }

    @Override
    public void attack(Character character) {
        this.heal(this);
        character.takeDamage(10);
    }

    @Override
    public String toString(){
        if (this.getCurrentHealth() > 0){
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", this.getName(), this.getCurrentHealth(), this.healCapacity);
        }
        return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", this.getName(), this.healCapacity);
    }



}