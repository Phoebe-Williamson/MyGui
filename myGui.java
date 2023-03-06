import ecs100.*;
import java.awt.Color; 
/**
 * mainkg dome sliders and responding to mojuse events
 *
 * @author (Phoebe williamosn)
 * @version (7/3/23)
 */
public class myGui
{
    // instance variables - replace the example below with your own
    private double speed;

    /**
     * Constructor for objects of class myGui
     */
    public myGui()
    {
        // initialise instance variables
        speed = 0;
        
        // set up buttons
        UI.addButton("Quit", UI::quit);
        
        // setup slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
    }
    
    /**
     * call back metjod for speed slider
     */
    public void setSpeed(double km) {
        // check if it is greater or less than last speed
        if (speed < km) {
            UI.println("Accelerating");
        } else if (speed > km) {
            UI.println("Decelerating");
        } else {
            UI.println("Stationary");
        }
    }
}
