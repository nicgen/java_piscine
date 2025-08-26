public interface Sorcerer implements Healer {
    private final int healCapacity();

    public Sorcerer (String name, int maxHealth, int healCapacity){
        super(name, maxHealth);
        this.healCapacity =
    };
}