import ecs100.*;
import java.awt.Color; 
import javax.swing.JColorChooser;
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
    
    // fileds to remember the pressed position
    private double startX, startY; 

    // remember the oclour
    private Color currentColor = Color.black;
    /**
     * Constructor for objects of class myGui
     */
    public myGui()
    {
        // initialise instance variables
        speed = 0;
        
        // set up buttons
        UI.addButton("Quit", UI::quit);
        UI.addButton("Colour", this::chooseColour);
        UI.addButton("random Colour", this::changeColour);
        UI.addButton("Clear", this::doClear);
        
        // setup slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
        
        // setup mouse listener
        UI.setLineWidth(10);
        UI.setMouseListener(this::doMouse);
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
    
    /**
     * call back method to mouse responder
     * only make one call back method to the mouse listener
     */
    public void doMouse(String action, double x, double y) {
        double width = 50;
        double height = 50;
        if (action.equals("clicked")) {
            UI.fillOval(x-width/2, y-height/2, width, height);
        } else if (action.equals("released")){
            UI.drawLine(this.startX, this.startY, x, y);
        } else if (action.equals("pressed")){
            this.startX = x;
            this.startY = y; 
        }
    }
    
    /**
     * change to a random colour
     */
    public void changeColour(){
        Color col = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        UI.setColor(col);
    }
    
    /**
     * allows user to use a colur for the swing libary
     */
    public void chooseColour() {
        this.currentColor = JColorChooser.showDialog(null, "Coose Colour", this.currentColor);
        UI.setColor(this.currentColor);
    }
    
    /**
     * make the screen clear
     * 
     */
    public void doClear() {
        UI.setColor(Color.white);
        UI.fillRect(0, 0, 100000, 100000);
        
    }
}
