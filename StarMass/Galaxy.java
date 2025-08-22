import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects; // List of celestial objects

    public Galaxy() {
        celestialObjects = new ArrayList<>();// Initialize the list of celestial objects
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;// Return the list of celestial objects
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        celestialObjects.add(celestialObject);// Add a celestial object to the list
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> massRepartition = new HashMap<>();// Initialize the map
            massRepartition.put("Star", 0);// Add the keys
            massRepartition.put("Planet", 0);// Add the keys
            massRepartition.put("Other", 0);// Add the keys
        for (CelestialObject obj : celestialObjects) {// For each celestial object
            int mass = obj.getMass();// Get the mass
            if (obj instanceof Star) {// If the object is a star
                massRepartition.put("Star", massRepartition.get("Star") + mass);// Add the mass to the star key
            } else if (obj instanceof Planet) {// If the object is a planet
                massRepartition.put("Planet", massRepartition.get("Planet") + mass);// Add the mass to the planet key
            } else {
                massRepartition.put("Other", massRepartition.get("Other") + mass);// Add the mass to the other key
            }
        }
        return massRepartition;// Return the map
    }
}