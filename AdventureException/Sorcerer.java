public class Sorcerer extends Character implements Healer {

    private final int healCapacity;
    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon){
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.adventureClass = "sorcerer";
    }

    @Override
    public int getHealCapacity(){
        return this.healCapacity;
    }

    @Override
    public void heal(Character character){
        if (this.healCapacity + character.getCurrentHealth() <= character.getMaxHealth()) {
            character.setCurrentHealth(this.healCapacity + character.getCurrentHealth());
        }else{
            character.setCurrentHealth(character.getMaxHealth());
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (this.getCurrentHealth() - damage <= 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(this.getCurrentHealth() - damage);
        }
    }

    @Override
    public void attack(Character character) {
        this.heal(this);
        if (this.getWeapon() != null) {
            character.takeDamage(this.getWeapon().getDamage());
        } else {
            character.takeDamage(10);
        }
    }

    @Override
    public String toString(){
        if (this.getCurrentHealth() > 0){
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP. He has the weapon %s.", this.getName(), this.getCurrentHealth(), this.healCapacity, this.getWeapon().getName());
        }
        return String.format("%s is a dead sorcerer. So bad, it could heal %d HP. He has the weapon %s.", this.getName(), this.healCapacity, this.getWeapon().getName());
    }
}