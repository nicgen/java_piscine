public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super(); // Call the superclass default constructor
        centerStar = new Star(); // Initialize centerStar with default Star
    }

    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(x, y, z, name, mass); // Call the superclass constructor with full parameters
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar; // Return the centerStar
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar; // Set the centerStar
    }

    @Override // Override the hashCode method
    public int hashCode() {
        return super.hashCode() + centerStar.hashCode();// Return the hash code of the object
    }

    @Override // Override the equals method
    public boolean equals(Object object) {
        if (this == object) return true; // If the object is compared with itself then return true
        if (object == null || getClass() != object.getClass()) return false; // Check if object is an instance of Planet

        if (!super.equals(object)) return false; // Check if the superclass equals method returns false

        Planet planet = (Planet) object; // Cast the object to Planet

        return centerStar.equals(planet.centerStar); // Return true if the centerStar of both objects are equal
    }

    // Override toString
    @Override
    public String toString() {
        double distanceWithCenterStar = CelestialObject.getDistanceBetween(this, centerStar); // Get the distance between the planet and the centerStar
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distanceWithCenterStar); // Return the string
    }
}