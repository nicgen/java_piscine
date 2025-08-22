public class Star extends CelestialObject {
    private double magnitude;// The magnitude of the star

    public Star() {// Default constructor
        super();// Call the default constructor of the parent class (CelestialObject)
        magnitude = 0.0;// Initialize the magnitude
    }

    public Star(String name, double x, double y, double z, double magnitude, int mass) {// The constructor is public
        super(name, x, y, z, mass);// Call the constructor of the parent class (CelestialObject)
        this.magnitude = magnitude;// Initialize the magnitude
    }


    public double getMagnitude() {// Getter
        return magnitude;// Return the magnitude
    }

    public void setMagnitude(double magnitude) {// Setter
        this.magnitude = magnitude;// Set the magnitude
    }

    @Override// Override the method from the parent class (CelestialObject)
    public int hashCode() {// The method is public
        return Double.hashCode(magnitude) + super.hashCode();// Return the hash code
    }

    @Override// Override the method from the parent class (CelestialObject)
    public boolean equals(Object object) {// The method is public
        if (this == object) return true;// If the object is compared with itself then return true
        if (object == null || getClass() != object.getClass()) return false;// Check if object is an instance of Star

        if (!super.equals(object)) return false;// Check if the superclass equals method returns false

        Star star = (Star) object; // Cast the object to Star

        return Double.compare(star.magnitude, magnitude) == 0;// Return true if the magnitude of both objects are equal
    }

    @Override// Override the method from the parent class (CelestialObject)
    public String toString() {// The method is public
        return getName() + " shines at the " + String.format("%.3f", magnitude) + " magnitude";// Return the string
    }
}