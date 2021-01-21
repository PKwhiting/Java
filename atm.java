import java.util.Scanner;
import java.util.ArrayList;

class atm { 
    //write methods here
    public static void main(String[] args) {
        boolean cont = true;
        Scanner in = new Scanner(System.in);
        int i = 0;
        ArrayList<account> accounts = new ArrayList<>();
        accounts.add(new checkings("admin", "admin", "admin@admin.com", 1234, 10000));
        System.out.println("Welcome to General ATM!\n Do you hold an account with us?(y/n)");
        //loop breaks when user is done
        while (cont != false){
            String input  = in.nextLine();
            //verifies if user has an account or not
            if (input.equals("y") || input.equals("yes")) {
                System.out.print("Please enter pin\n");
                int userPin = in.nextInt();
                in.nextLine();
                //verifies correct PIN
                for (int j = 0; j < accounts.size(); j++){
                    int temp = accounts.get(j).getPin();
                    if (temp == userPin) {
                        //maked deposits and withdrawals from existing accounts
                        if (accounts.get(j) instanceof checkings){
                            System.out.println("Would you like to withdraw or make a deposit from your checkings(w/d)?");
                            input = in.nextLine();
                            if (input.equals("w")){
                                var object = accounts.get(j);
                                System.out.print("Your accounts balance is " + ((checkings)object).getAmount() + "\n");
                                System.out.print("How much would you like to withdraw?\n");
                                int withdrawAmount = in.nextInt();
                                ((checkings)object).withdraw(withdrawAmount);
                                System.out.print("Your new accounts balance is " + ((checkings)object).getAmount() + "\n");
                                cont = false;
                                break;
                            }
                            else if (input.equals("d")){
                                var object = accounts.get(j);
                                System.out.print("Your accounts balance is " + ((checkings)object).getAmount() + "\n");
                                System.out.print("How much would you like to deposit?\n");
                                int depositAmount = in.nextInt();
                                ((checkings)object).makeDeposit(depositAmount);
                                System.out.print("Your new accounts balance is " + ((checkings)object).getAmount() + "\n");
                                cont = false;
                                break;
                            }
                            
                        }
                        else if (accounts.get(j) instanceof savings){
                            System.out.println("Would you like to withdraw or make a deposit from your savings(w/d)?\n");
                            input = in.nextLine();
                            if (input.equals("w")){
                                var object = accounts.get(j);
                                System.out.print("Your accounts balance is " + ((savings)object).getAmount() + "\n");
                                System.out.print("How much would you like to withdraw?\n");
                                int withdrawAmount = in.nextInt();
                                ((checkings)object).withdraw(withdrawAmount);
                                System.out.print("Your new accounts balance is " + ((savings)object).getAmount() + "\n");
                                cont = false;
                                break;
                            }
                            else if (input.equals("d")){
                                var object = accounts.get(j);
                                System.out.print("Your accounts balance is " + ((savings)object).getAmount() + "\n");
                                System.out.print("How much would you like to deposit?\n");
                                int depositAmount = in.nextInt();
                                ((checkings)object).makeDeposit(depositAmount);
                                System.out.print("Your new accounts balance is " + ((savings)object).getAmount() + "\n");
                                cont = false;
                                break;
                            }
                            
                        }
                    }
                    else {
                        System.out.println("Incorrect PIN\n System Locked \n Goodbye");
                        cont = false;
                        break;
                    }
                }
            }
            //if user does not have account
            else if (input.equals("n")) {
                System.out.print("Would you like to make an account?(y/n)\n");
                input = in.nextLine();
                if (input.equals("n") || input.equals("no")){
                    System.out.print("Thank you, goodbye");
                    cont = false;
                    break;
                }
                else {
                    //creates an ATM account
                    System.out.print("What is your first name?\n");
                    String fname = in.nextLine();
                    System.out.print("What is your last name?\n");
                    String lname = in.nextLine();
                    System.out.print("What is your email?\n");
                    String email = in.nextLine();
                    System.out.print("What is your pin?\n");
                    int pin = in.nextInt();
                    in.nextLine();
                    System.out.print("Would you like to set up a savings or checkings?(s/c)\n");
                    input = in.nextLine(); 
                    if (input.equals("s")){
                        System.out.print("Would you like to make an initial deposit?(y/n)\n");
                        input = in.nextLine();
                        if (input.equals("y")){
                            System.out.print("How much would you like to depost\n");
                            int deposit = in.nextInt();
                            accounts.add(new savings(fname, lname, email, pin, deposit));
                            System.out.println("Your account has been made!\n");
                            break;
                        }
                        else {
                            accounts.add(new savings(fname, lname, email, pin, 0));
                            System.out.println("Your account has been made!\n");
                            break;
                        }
                        
                    }
                    else if (input.equals("c")){
                        System.out.print("Would you like to make an initial deposit?(y/n)\n");
                        input  = in.nextLine();
                        if (input.equals("n")){
                            System.out.print("How much would you like to depost\n");
                            int deposit = in.nextInt();
                            accounts.add(new checkings("admin", "admin", "admin@admin.com", 0000, deposit));
                            System.out.println("Your account has been made!\n");
                        }
                        else {
                            accounts.add(new savings("admin", "admin", "admin@admin.com", 0000, 0));
                            System.out.println("Your account has been made!\n");
                        }
                        
                    }
                }
            }
        }
    System.out.print("Thank you for your business.\n");
    }
}