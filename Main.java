import java.util.Scanner;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int pin = 1234;

    public static void main(String[] args) {

        if(!login()) {
            System.out.println("Too many wrong attempts, Card Blocked.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        double balance = 0;
        boolean isRunning = true;
        int choice;
        int transactions = 0;
        String t1="", t2="", t3="", t4="", t5="";

        while (isRunning) {

            System.out.println("BANKING PROGRAM");
            System.out.println("************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Money");
            System.out.println("5. Mini Statements");
            System.out.println("6. Exit");
            System.out.println("************");

            System.out.println("Enter your choice (1-4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showbalance(balance);

                case 2 -> {


                    double amount = deposit();
                    balance += amount;
                    transactions++;

                    if(transactions==1) t1="Deposited Rs "+amount;
                    else if(transactions==2) t2="Deposited Rs "+amount;
                    else if(transactions==3) t3="Deposited Rs "+amount;
                    else if(transactions==4) t4="Deposited Rs "+amount;
                    else if(transactions==5) t5="Deposited Rs "+amount;

                        System.out.println("Updated Balance: Rs " + balance);
                    }

                case 3 -> {
                    double amount = withdraw(balance);
                    balance -= amount;
                    transactions++;

                    if(transactions==1) t1="Withdraw Rs "+amount;
                    else if(transactions==2) t2="Withdraw Rs "+amount;
                    else if(transactions==3) t3="Withdraw Rs "+amount;
                    else if(transactions==4) t4="Withdraw Rs "+amount;
                    else if(transactions==5) t5="Withdraw Rs "+amount;

                        System.out.println("Remaining Balance: Rs " + balance);
                }

                case 4 -> {
                    double amount = transfer(balance);
                    balance -= amount;
                    transactions++;

                    if(transactions==1) t1="Transfer Rs "+amount;
                    else if(transactions==2) t2="Transfer Rs "+amount;
                    else if(transactions==3) t3="Transfer Rs "+amount;
                    else if(transactions==4) t4="Transfer Rs "+amount;
                    else if(transactions==5) t5="Transfer Rs "+amount;
                    System.out.println("Remaining Balance: " + balance);
                }

                case 5 -> {

                    System.out.println("---- Mini Statement ----");

                    System.out.println(t1);
                    System.out.println(t2);
                    System.out.println(t3);
                    System.out.println(t4);
                    System.out.println(t5);

                    System.out.println("Available Balance" + balance);
                }

                case 6 -> isRunning = false;
                    default -> System.out.println("Invalid choice");

            }
        }
        sc.close();
    }

    static boolean login(){

        int attempts = 3;

        while(attempts > 0) {
            System.out.println("Enter ATM PIN: ");
            int enteredPin = sc.nextInt();

            if(enteredPin == pin) {
                System.out.println("Login Successful");
                return true;
            }
            attempts--;
            System.out.println("Wrong PIN! \n Attempts left: " + attempts);
        }
        return false;
    }


    static double showbalance(double balance) {
        System.out.println("Rs " + balance);
        return balance;
    }

    static double deposit() {
           double amount;

           System.out.println("Enter an amount to  be deposited: ");
           amount = sc.nextDouble();

        System.out.println("Amount Deposited Successfully");

           if (amount < 0) {
               System.out.println("Amount cannot be negative");
               return 0;
           } else {
               return amount;
           }

    }

    static double withdraw(double balance) {

        double amount;

        System.out.println("Enter amount to be withdrawn: ");
        amount = sc.nextDouble();

        System.out.println("Amount Withdrawn Successfully");


        if (amount > balance) {
            System.out.println("INSUFFICIENT FUNDS");
            return 0;
        } else if (amount < 0) {
            System.out.println("Amount cannot be below Zero");
            return 0;
        } else {
            return amount;
        }
    }

         static double transfer(double balance) {
            long accountNumber;
            double amount;

            System.out.println("Enter account number: ");
            accountNumber = sc.nextLong();

            System.out.println("Enter amount to transfer: ");
            amount = sc.nextDouble();

            if(amount > balance){
                System.out.println("Insufficient funds to transfer");
                return 0;
            }

            if(amount <= 0){
                System.out.println("Invalid amount");
                return 0;
            }
            System.out.println("Transfer successful to account " + accountNumber + "of Rs " + amount);
            return amount;
        }

    }
