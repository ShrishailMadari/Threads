package wildcards;

import java.util.List;

class Vehicle{
    private final String name;


    public Vehicle(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Vehicle: " + name);
    }
}
class VehicleProcessor  {
    public static void vehicleDisplay(List<? extends Vehicle> vehicles){
        for (Vehicle vehicle: vehicles){
            vehicle.display();
        }
    }
}
public class Test{
    public static void main(String[] args) {

    }
}
class Bus extends Vehicle{
    String string;
    public Bus(String name) {
        super(name);
    }
}
class Car extends Vehicle{
    public Car(String name) {
        super(name);
    }

}
