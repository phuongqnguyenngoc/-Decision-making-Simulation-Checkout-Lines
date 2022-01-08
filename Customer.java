import java.util.ArrayList;

abstract class Customer {
    private int numItems;
    private int timeSteps;
    private int type;

    //constructor method
    public Customer(int num_items) {
        this.numItems = num_items;
        this.timeSteps = 0;
        this.type = 0;
    }

    public Customer(int num_items, int time_steps) {
        this.numItems = num_items;
        this.timeSteps = time_steps;
        this.type = 0;
    }

    //constructor method.
    public Customer(int num_items, int time_steps, int type) {
        this.numItems = num_items;
        this.timeSteps = time_steps;
        this.type = type;
    }

    //increments the number of time steps.
    public void incrementTime() {
        this.timeSteps ++;
    }

    //returns the number of time steps
    public int getTime() {
        return this.timeSteps;
    }

    //returns the type of the customer
    public int getType() {
        return this.type;
    }

    //decrements the number of items
    public void giveUpItem() {
        this.numItems --;
    }

    //returns the number of items.
    public int getNumItems() {
        return this.numItems;
    }

    //returns the line the customer choose based on specific strategy, will be defined in the child class
    public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts);
}