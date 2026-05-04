package Oops_Concept;

//🔥 What is Abstraction?
//Abstraction means hiding implementation details and exposing only the
// essential functionality to the user.
//
//🧠 Real-world analogy
//Think of a Payment Gateway (Razorpay / Stripe / PayPal):
//You do:
//pay(1000)
//But you DON'T know:
//
//how encryption happens
//how bank communication works
//how fraud check happens
//👉 That hidden complexity = Abstraction
//❌ 1. WITHOUT Abstraction (BAD DESIGN)
//Problem: Tight coupling, hard to extend

//👉 Abstraction is the process of hiding implementation details and
// exposing only essential behavior. It is achieved using interfaces
// and abstract classes,
// allowing loose coupling and scalable design.

class PaymentService{
    public void payWithCreditCard(double amount){
        System.out.println("paid" + amount+ "using credit card");
    }
    public  void payWithUPI(double amount){
        System.out.println("paid"+ amount+ "using UPI");
    }
}
public class Abstraction1Demo {

    public static void main(String[] args) {
        PaymentService payment=new PaymentService();
        payment.payWithCreditCard(1000);
        payment.payWithUPI(500);
    }
}
