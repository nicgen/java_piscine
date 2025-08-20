public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super(); // Call the superclass default constructor
        centerStar = new Star(); // Initialize centerStar with default Star
    }

    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(x, y, z, name); // Call the superclass constructor with full parameters
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + centerStar.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if (!super.equals(object)) return false;

        Planet planet = (Planet) object;

        return centerStar.equals(planet.centerStar);
    }

 // Override toString
 @Override
 public String toString() {
 double distanceWithCenterStar = CelestialObject.getDistanceBetween(this, centerStar);
 return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distanceWithCenterStar);
 }
}