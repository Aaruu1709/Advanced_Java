package Oops_Concept;
//Polymorphism means “one thing having many forms”.

//But in real engineering:
//
//👉 Same interface/method → behaves
// differently depending on the object at runtime or compile time.

//Think of a Payment button:
//
//You click:
//
//UPI → different processing
//Card → different processing
//NetBanking → different processing
//
//👉 Same action: pay()
//👉 Different behavior based on type

//🔹 TYPES OF POLYMORPHISM
//1. Compile-time Polymorphism (Method Overloading)
//2. Runtime Polymorphism (Method Overriding)

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}


public class PolyMorphism {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(2, 3));
        System.out.println(c.add(2.5, 3.5));
        System.out.println(c.add(1, 2, 3));
    }
}
//👉 Same method name, different inputs →
// compiler decides which method to call