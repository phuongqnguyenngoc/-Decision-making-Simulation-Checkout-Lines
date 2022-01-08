import java.awt.Graphics;
import java.awt.Color;

public class CheckoutAgent {
    private int x;
    private int y;
    private MyQueue<Customer> theQueue;

    //constructor
    public CheckoutAgent(int x, int y) {
        this.x = x;
        this.y = y;
        this.theQueue = new MyQueue<Customer>();
    }

    //add a Customer to the queue.
    public void addCustomerToQueue (Customer c) {
        theQueue.offer(c);
    }

    //returns the number of Customers in the queue.
    public int getNumInQueue() {
        return theQueue.getSize();
    }

    //return the queue so that other classes can access it
    public MyQueue<Customer> getTheQueue() {
        return this.theQueue;
    }

    

   
    //draw the queue of customers for the CheckoutAgent
    public void draw(Graphics g) {
        //set the position for y
        int old_y = this.y;
        //a list of character to draw the number of items of each customer
        char[] value = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X'};
        //for each customer, draw it with a white space to seperate with the prev and next customer
        for (int i = 0; i < this.getNumInQueue(); i ++) {
            if (this.getTheQueue().toArrayList().get(i).getType() == 0) {
                g.setColor(Color.blue.darker().darker());
            } else if (this.getTheQueue().toArrayList().get(i).getType() == 1) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.green.darker().darker());
            }
            
            g.fill3DRect(this.x, old_y - 17, 20, 17, true);
            g.setColor(Color.white);
            g.fillRect(this.x, old_y - 20, 20, 3);
            g.setColor(Color.white);
            //draw number of items on each rectangular that represents a customer
            g.drawChars(value, this.getTheQueue().toArrayList().get(i).getNumItems(), 1, this.x + 5, old_y - 5);
            //set y to higher coordinate
            old_y -= 20;
            
        }
    }

    //update the customer state
    public void updateState(Landscape scape) {
        //increment time for each customer
        for (Customer c: theQueue) {
            c.incrementTime();
            
        } 
        
        Customer front = theQueue.peek();
        if ( front!= null) { 
            //if the queue has the front customer, give up the customer's items until there is nothing left
            if (front.getNumItems() != 0) {
                front.giveUpItem();
            } else {
                //then sort the customer into the Linkedlist according to its type
                if (front.getType() == 0) {
                    scape.getLLType0().addLast(front);
                } else if (front.getType() == 1) {
                    scape.getLLType1().addLast(front);
                } else if (front.getType() == 2) {
                    scape.getLLType2().addLast(front);
                }
                //poll the customer out of the queue and add it to the addFinishedCustomer LinkedList
                scape.addFinishedCustomer(theQueue.poll());
            }
           
        }
        
        

    }
}