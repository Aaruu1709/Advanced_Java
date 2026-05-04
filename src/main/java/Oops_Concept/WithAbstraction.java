package Oops_Concept;

interface PaymentService1 {
    void pay(double amount);
}
class CreditCardPayment implements PaymentService1 {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentService1 {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class NetBankingPayment implements PaymentService1 {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Net Banking");
    }
}


public class WithAbstraction {
    public static void main(String[] args) {

        PaymentService1 payment1 = new CreditCardPayment();
        PaymentService1 payment2 = new UpiPayment();
        PaymentService1 payment3 = new NetBankingPayment();


        payment1.pay(1000);
        payment2.pay(500);
        payment3.pay(2000);
    }
}

//| Without Abstraction | With Abstraction             |
//        | ------------------- | ---------------------------- |
//        | Fixed methods       | Flexible design              |
//        | Hard to extend      | Easy to add new payment type |
//        | Tight coupling      | Loose coupling               |
//        | Not scalable        | Highly scalable              |

//⚡ Why this is powerful
//
//✔ You can add new payment type without touching old code
//✔ System follows Open/Closed Principle
//✔ Easy testing (mock interfaces)
//✔ Clean architecture for microservices