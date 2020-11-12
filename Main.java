


public class Main {


    public static void main(String[] args){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.startEngine();
        volvo.startEngine();

        volvo.gas(2.2);
        volvo.brake(2.2);




    }
}
