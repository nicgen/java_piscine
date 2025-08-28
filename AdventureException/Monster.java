public class Monster extends Character{

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);this.adventureClass = "monster";
    }

    @Override
    public String toString(){
        if (this.getCurrentHealth() == 0){
            return String.format("%s is a monster and is dead. He has the weapon %s.", this.getName(), this.getWeapon().getName());
        }
        return String.format("%s is a monster with %d HP. He has the weapon %s.", this.getName(), this.getCurrentHealth(), this.getWeapon().getName());
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
    public void attack(Character character) {
        if (this.getWeapon() != null) {
            character.takeDamage(this.getWeapon().getDamage());
        } else {
            character.takeDamage(7);
        }
    }

}