package Oops_Concept;

class BankAccout{
    public double balance;

}
public class WithoutEncapsulation {
    public static void main(String[] args) {
  BankAccout accout=new BankAccout();

  //direct access
        accout.balance=1000;
        System.out.println("initial balance:"+ accout.balance);

        //no validation
        accout.balance=-5000;
        System.out.println("final balance: "+ accout.balance);
    }
}

//
//🚨 Problems in this approach (real industry issues)
//Anyone can set invalid values
//No business rules enforced
//No validation (negative balance allowed)
//Hard to debug production issues
//Not scalable for banking/enterprise systems
//
//👉 This design would NEVER be accepted in real backend systems.