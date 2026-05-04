package Oops_Concept;

//2️⃣ Runtime Polymorphism (OVERRIDING)
//🔥 What it means:
//
//Child class changes parent class behavior

class Payment {
    void pay() {
        System.out.println("Generic payment");
    }
}

class UpiPayment2 extends Payment {
    @Override
    void pay() {
        System.out.println("UPI payment processed");
    }
}

class CardPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Card payment processed");
    }
}

public class RuntimePolyMorphism {
    public static void main(String[] args) {
        Payment p1 = new UpiPayment2();
        Payment p2 = new CardPayment();

        p1.pay(); // UPI
        p2.pay(); // Card
    }
}
//🧠 WHAT IS HAPPENING HERE?
//👉 Reference type = Payment
//👉 Object type = UpiPayment/CardPayment
//✔ JVM decides at runtime which method to execute
//| Overloading          | Overriding            |
//| -------------------- | --------------------- |
//| Compile time         | Runtime               |
//| Same class           | Parent-child          |
//| Different parameters | Same method signature |

//Q2: Why is runtime polymorphism important?
//
//👉 Because system behavior can change dynamically at runtime (like Spring Boot services)

//| Concept       | Role                    |
//| ------------- | ----------------------- |
//| Encapsulation | Protect data            |
//| Abstraction   | Hide complexity         |
//| Inheritance   | Reuse structure         |
//| Polymorphism  | Flexibility in behavior |