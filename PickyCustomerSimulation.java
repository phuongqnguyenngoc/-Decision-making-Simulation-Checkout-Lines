import java.util.Random;
import java.util.ArrayList;

public class PickyCustomerSimulation {
    public static void main (String[] args) throws InterruptedException {
        Random gen = new Random();

        // create an arraylist contains 5 CheckoutAgent
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);

        for(int i=0;i<5;i++) {
            CheckoutAgent checkout = new CheckoutAgent( i*100+50, 480 );
            checkouts.add( checkout );
        }
        Landscape scape = new Landscape(500,500, checkouts);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        
        //add 1000 Pick2Customer to the landscape
        for (int j = 0; j < 1000; j++) {
            Customer cust = new PickyCustomer(1+gen.nextInt(10), checkouts.size());
            int choice = cust.chooseLine( checkouts );
            checkouts.get(choice).addCustomerToQueue( cust );
            display.repaint();
            Thread.sleep( 250 );
            scape.updateCheckouts();

            //print statistics for each 10 time steps
            if (j % 100 == 99) {
                scape.printFinishedCustomerStatistics();
            }
        }

    
    }
}