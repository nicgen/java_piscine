public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super(); // Call the default constructor of the parent class (CelestialObject)
        magnitude = 0.0; // Initialize the magnitude
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }
}