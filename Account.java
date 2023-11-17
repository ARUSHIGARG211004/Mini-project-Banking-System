public class Account {
        int accountNumber;
        double balance;
        Account(int accountNumber,double balance){
                this.accountNumber=accountNumber;
                this.balance=balance;
        }

void deposit(double amount) {
        balance = balance + amount;
}
void withdraw(double amount) {
        if (balance > amount) {
                balance = balance - amount;
        }
        else{
                System.out.println("insufficient balance.");
        }
}
int getAccountNumber(){
        return  accountNumber;
        }


double getBalance(){
                return balance;
        }
        String toString1(){
                return("Account"+accountNumber+":"+"$"+balance);
        }
}

public class savingAccount extends Account{
    double interestRate;
    savingAccount(int accountNumber,double balance,double interestRate){
        super(accountNumber,balance);
        this.interestRate=interestRate;
    }
    void applyinterest(){
        double interest= getBalance()* interestRate/100;
        deposit(interest);
    }
}
public class checkingAccount extends Account{
    double overdraftLimit;
    checkingAccount(int accountNumber,double Balance, double overdraftLimit){
        super(accountNumber,Balance);
        this.overdraftLimit=overdraftLimit;
    }
    void withdraw(double amount){
        if(getBalance()+overdraftLimit>=amount){
            balance=balance-amount;
        }
        else{
            System.out.println("not sufficient balance");
        }
    }
}
public class bank {
    public static void main(String[]args){
        savingAccount s= new savingAccount(1001,1000.0,5.0);
        checkingAccount c=new checkingAccount(2001,500.0,200.0);
        System.out.println(s);
        System.out.println(c);
        s.deposit(200.0);
        c.deposit(100.0);
        System.out.println("after deposit");
        System.out.println(s.toString1());
        System.out.println(c.toString1());
        s.applyinterest();
        c.withdraw(800.0);
        System.out.println("after interest and withdrawal:");
        System.out.println(s.toString1());
        System.out.println(c.toString1());


    }
}
