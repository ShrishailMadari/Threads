package wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Vehicle{
    private String name;

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
        List<Vehicle> vehicles = Arrays.asList(new Vehicle("BMW"),new Vehicle("Tesla"),new Vehicle("Audi"));
        List<Bus> busList = Arrays.asList(new Bus("sami"),new Bus("war"),new Bus("carry"));
        List<Car> carList = Arrays.asList(new Car("BMW"), new Car("Audi"));
        List<Bike> bikeList = Arrays.asList(new Bike("Yamaha"), new Bike("Ducati"));        VehicleProcessor.vehicleDisplay(vehicles);
        VehicleProcessor.vehicleDisplay(busList);
        VehicleProcessor.vehicleDisplay(carList);
        VehicleProcessor.vehicleDisplay(busList);
    }
}
class Bike extends Vehicle{


    public Bike(String name) {
        super(name);
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
