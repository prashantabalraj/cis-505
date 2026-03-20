/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class Fan {

    // Constants representing fan speeds
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Data fields for fan properties
    private int speed;        // Current speed of the fan
    private boolean isOn;     // Indicates whether the fan is on or off
    private double radius;   // Radius of the fan
    private String color;    // Color of the fan

    /**
     * Default constructor
     * Initializes the fan with default values
     */
    public Fan() {
        speed = STOPPED;
        isOn = false;
        radius = 6.0;
        color = "white";
    }

    /**
     * Parameterized constructor
     * @param speed  the speed of the fan
     * @param isOn   whether the fan is on or off
     * @param radius the radius of the fan
     * @param color  the color of the fan
     */
    public Fan(int speed, boolean isOn, double radius, String color) {
        this.speed = speed;
        this.isOn = isOn;
        this.radius = radius;
        this.color = color;
    }

    // Getter for speed
    public int getSpeed() {
        return speed;
    }

    // Setter for speed
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Getter for fan status
    public boolean isOn() {
        return isOn;
    }

    // Setter for fan status
    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns a string representation of the fan
     * @return formatted string describing the fan
     */
    @Override
    public String toString() {
        if (isOn) {
            return "The fan speed is set to " + speed +
                   " with a color of " + color +
                   " and a radius of " + radius;
        } else {
            return "The fan is " + color +
                   " with a radius of " + radius +
                   " and the fan is off";
        }
    }
}