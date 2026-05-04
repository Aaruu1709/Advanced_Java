package Oops_Concept;
//👉 Inheritance is an OOP concept where one class acquires
//  properties and behaviors of another class, promoting code
//reuse and hierarchical design.
//It is used when an IS-A relationship exists.


//Step 1: Create parent class
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting...");
    }

    void stop() {
        System.out.println("Vehicle is stopping...");
    }
}
//class ElectricCar extends Vehicle {
//
//    @Override
//    void start() {
//        System.out.println("Electric car silent start");
//    }
//}
//we can add extra classes to
class Car extends Vehicle {
    void musicSystem() {
        System.out.println("Music system ON");
    }
}

//Step 2: Child classes inherit behavior
class Bike extends Vehicle {
    void kickStart() {
        System.out.println("Bike kick start");
    }
}

//Step 3: Use it
public class inheritance1 {
    public static void main(String[] args) {
        Car car=new Car();
        car.start();
        car.musicSystem();


        Bike bike =new Bike();
        bike.start();
        bike.kickStart();
    }
}
