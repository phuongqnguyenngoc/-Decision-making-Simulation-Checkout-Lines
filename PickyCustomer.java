import java.util.ArrayList;

public class PickyCustomer extends Customer {
    

    //constructor calls the super class's constructor with the given number of items and num_lines as the initial value for the time steps
    public PickyCustomer (int num_items, int num_lines) {
        super(num_items, num_lines, 1);
        
    }

    //returns the index of the CheckoutAgent with the shortest line
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {
        int shortest = 100;
        int index = 100;

        for (int i = 0; i < checkouts.size(); i ++) {
            if (shortest > checkouts.get(i).getNumInQueue()) {
                shortest = checkouts.get(i).getNumInQueue();
                index = i;
            }
        }
        return index;  
    }
}