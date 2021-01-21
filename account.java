import java.util.Random;
public class account{
    String fname;
    String lname;
    String email;
    int pin;
    int[] acctNumber = new int[9];
    public account (String firstName, String lastName, String Email, int pinNumber){
        Random rand = new Random();
        fname = firstName;
        lname = lastName;
        email = Email;
        pin = pinNumber;
        for (int i = 0; i < 9; i++){
            acctNumber[i] = rand.nextInt(10);
        }
    }
    public int getPin(){
        return pin;
    }
    public int[] getAcctNumber(){
        return acctNumber;
    }
}


