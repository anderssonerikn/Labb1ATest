import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    public Saab95(){
        super(4, 100, Color.black, "Volvo240");
        turboOn = false;
    }

    /**
     * Sätter värdet i speedFactor till true för att öka hur fort bilen ökar.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }


    /**
     * Bestämmer hur fort bilen ökar sin hastighet.
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
