import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.*;

public class Landscape {
    private int width;
    private int height;
    private ArrayList<CheckoutAgent> checkouts;
    private LinkedList<Customer> customerCheckout;
    //added LinkedList fields to hold CheckoutCustomer according to its type
    private LinkedList<Customer> type0;
    private LinkedList<Customer> type1;
    private LinkedList<Customer> type2;

    //constructor
    public Landscape(int w, int h, ArrayList<CheckoutAgent> checkouts) {
        this.width = w;
        this.height = h;
        this.checkouts = checkouts;
        this.customerCheckout = new LinkedList<Customer>();
        this.type0 = new LinkedList<Customer>();
        this.type1 = new LinkedList<Customer>();
        this.type2 = new LinkedList<Customer>();
    }

    //return the LinkedList of customers type 0 (random)
    public LinkedList getLLType0() {
        return type0;
    }

    //return the LinkedList of customers type 1 (picky)
    public LinkedList getLLType1() {
        return type1;
    }

    //return the LinkedList of customers type 2 (pick2)
    public LinkedList getLLType2() {
        return type2;
    }

    //return the height of the Landscape.
    public int getHeight() {
        return this.height;
    }

    //return the width of the Landscape.
    public int getWidth() {
        return this.width;
    }

    //return a string indicating how many checkouts and finished customers are in the landscape.
    public String toString() {
        String state = "Checkouts: ";
        state += checkouts.size() + "; Finished customers: " + customerCheckout.size();
        return state;
    }

    //add the Customer to the list of finished customers.
    public void addFinishedCustomer (Customer c) {
        customerCheckout.addFirst(c);
    }

    //add the Customer to the list of type 0 customers.
    public void addCustomerType0 (Customer c) {
        type0.addFirst(c);
    }

    //add the Customer to the list of type 1 customers.
    public void addCustomerType1 (Customer c) {
        type1.addFirst(c);
    }

    //add the Customer to the list of type 2 customers.
    public void addCustomerType2 (Customer c) {
        type2.addFirst(c);
    }

    //loop through the CheckoutAgents, and call the draw method on each.
    public void draw (Graphics g) {
        for (CheckoutAgent c: checkouts) {
            c.draw(g);
        }
    }

    //loop through all of the CheckoutAgents, and call updateState.
    public void updateCheckouts() {
        for (CheckoutAgent c: checkouts) {
            c.updateState(this);
        }
    }

    
    // compute and print the average and standard deviation of the time-to-leave for all of the Customers in the finished customer list.
    public void printFinishedCustomerStatistics() {
        double total = 0;
        //caclculate total
        for (Customer c : customerCheckout) {
            total += c.getTime() ;
            // System.out.println("this time " + c.getTime());
        } 
        //calculate mean
        double mean = total / (double)customerCheckout.size();
        
        //calculate standard deviation
        double add = 0;
        for (Customer c : customerCheckout) {
            double i = ((double)c.getTime() - mean)*((double)c.getTime() - mean);
            add += i;
        }
        double standardDeviation = Math.sqrt(add / (double)customerCheckout.size());

        System.out.println("Mean: " + mean);
        System.out.println("Standard deviation: " + standardDeviation);


    }

    //compute and print the average and standard devation of the time-to-leave for the customers in the specific type LinkedList    
    public void printChooseStrategyCustomerStatistics(LinkedList<Customer> type) {
        double total = 0;
        //caclculate total
        for (Customer c : type) {
            total += c.getTime() ;
            // System.out.println("this time " + c.getTime());
        } 
        //calculate mean
        double mean = total / (double)type.size();
        
        //calculate standard deviation
        double add = 0;
        for (Customer c : type) {
            double i = ((double)c.getTime() - mean)*((double)c.getTime() - mean);
            add += i;
        }
        double standardDeviation = Math.sqrt(add / (double)type.size());
        System.out.println("Mean: " + mean);
        System.out.println("Standard deviation: " + standardDeviation);

    }

    

}