import javax.xml.stream.Location;
import java.awt.*;

/**
 * Created by Erik Andersson 20201111
 */

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private double[] pos = {0, 0}; //Position of the car
    private int direction; //Direction of the car

    /**
     * Riktningar som bilen kan röra sig i
     */
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    private final int[] LEFT = {3, 0, 1, 2}; //Change of directions when turning left
    private final int[] RIGHT = {1, 2, 3, 0}; //Change of directions when turning right

    /**
     * Dessa parametrar är egenskaper som samtliga bilar har och läggs därför i konstruktorn.
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName){
       this.nrDoors = nrDoors;
       this.enginePower = enginePower;
       this.currentSpeed = currentSpeed;
       this.color = color;
       this.modelName = modelName;
       this.direction = 0;
       stopEngine();
    }

    public int getNrDoors(){ return nrDoors; }

    public double getEnginePower(){
        return enginePower;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double newSpeed) {
        if(newSpeed >= 0 && newSpeed <= getEnginePower())
            currentSpeed = newSpeed;
        else
            System.out.println("Felaktigt värde inmatat!");
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void setDirection(int dir) { direction = dir; }
/*
    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);*/

    public abstract double speedFactor();

    /**
     * Flyttar bilens position beroende på riktning.
     */
    @Override
    public void move() {
        if(direction == 0)
            pos[1] += getCurrentSpeed();
        else if(direction == 1)
            pos[0] += getCurrentSpeed();
        else if(direction == 2)
            pos[1] -= getCurrentSpeed();
        else if(direction == 3)
            pos[0] -= getCurrentSpeed();
    }

    @Override
    public void turnLeft() {
        direction = LEFT[direction];
    }

    @Override
    public void turnRight() {
        direction = RIGHT[direction];
    }

    public void gas(double amount){
        if(validAmount(amount))
            incrementSpeed(amount);
        else
            System.out.println("Mata in ett värde mellan 0 och 1!!");
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

    public boolean validAmount(double amount){
        return (amount >= 0 && amount <= 1);
    }

    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + Math.abs(speedFactor()) * amount, getEnginePower()));
    }

    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - Math.abs(speedFactor()) * amount, 0));
    }
}
