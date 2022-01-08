import java.util.ArrayList;
import java.util.Random;

public class Pick2Customer extends Customer{
    //constructor
    public Pick2Customer( int num_items ) {
        super(num_items, 2, 2);
    }

    //returns the index of the CheckoutAgent with the shortest line
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {
        Random rand = new Random();
        int line1 = rand.nextInt(checkouts.size());
        int line2 = rand.nextInt(checkouts.size());
        while (line1 == line2) {
            line2 = rand.nextInt(checkouts.size());
        }
        if (checkouts.get(line1).getNumInQueue() < checkouts.get(line2).getNumInQueue()) {
            return line1;
        } else {
            return line2;
        }
    }
}