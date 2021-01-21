public class checkings extends account {
    int amount = 0;
    public checkings (String firstName, String lastName, String Email, int pinNumber, int deposit){
        super(firstName, lastName, Email, pinNumber);
        amount = deposit;

    }
    public int getAmount() {
        return amount;
    }
    public void makeDeposit(int deposit) {
        amount = amount + deposit;

    }
    public int withdraw(int withdrawAmounts) {
        amount = amount - withdrawAmounts;
        return amount;
    }
    
}
