package Oops_Concept;
//Fix: Make fields private + control access via methods

class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        if(initialBalance<0){
            throw new IllegalArgumentException("initial balance can not be negative...");
        }
        this.balance=initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount<=0){
            System.out.println("invalis deposit amount");
            return;
        }
        balance+=amount;
        System.out.println(amount+"deposit successfully");
    }

    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("invalid withdraw amount");
            return;
        }
        if(amount>balance){
            System.out.println("insufficient fund balance...");
        }
        balance-=amount;
        System.out.println(amount+ "withdraw not allowed");
    }
}
public class WithEncapsulation {
    public static void main(String[] args) {
BankAccount account=new BankAccount(1000);
        System.out.println("initial Balance:"+ account.getBalance());
    account.deposit(500);
    account.withdraw(300);

    //tring to do invalid operation
        account.withdraw(1200);
//        account.deposit(-200);
        System.out.println("final balance: "+ account.getBalance());
        account.withdraw(100);
        System.out.println("fund unavailable"+ account.getBalance());
    }
}
