public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super();
        magnitude = 0.0;
    }

    public Star(double x, double y, double z, String name, double magnitude) {
        super(x, y, z, name);
        this.magnitude = magnitude;
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        super(x, y, z, name);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(magnitude) + super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        if (!super.equals(object)) return false;

        Star star = (Star) object;

        return Double.compare(star.magnitude, magnitude) == 0;
    }

    @Override
    public String toString() {
        return getName() + " shines at the " + String.format("%.3f", magnitude) + " magnitude";
    }
}