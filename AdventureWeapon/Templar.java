public class Templar extends Character implements Tank, Healer {
    private final int shield;
    private final int healCapacity;
    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon){
        super(name, maxHealth,weapon);
        this.shield = shield;
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
    public int getShield(){
        return this.shield;
    }

    @Override
    public void takeDamage(int damage) {
        damage = damage - this.shield;
        if (damage > 0) {
            if (this.getCurrentHealth() - damage <= 0) {
                this.setCurrentHealth(0);
            } else {
                this.setCurrentHealth(this.getCurrentHealth() - damage);
            }
        }
    }

    @Override
    public void attack(Character character) {
        this.heal(this);
        if (this.getWeapon() != null) {
            character.takeDamage(this.getWeapon().getDamage());
        } else {
            character.takeDamage(6);
        }
    }


    @Override
    public String toString(){
        if (this.getCurrentHealth() > 0){
            return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", this.getName(), this.getCurrentHealth(), this.healCapacity, this.shield);
        }
        return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", this.getName(), this.shield, this.healCapacity);
    }



}