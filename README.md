# Decision-making-Simulation-Checkout-Lines
This project centers in the application of Queue. It illustrates real-life situation in a supermarket when customers line up and wait for their turn to be checked out. They have to make a decision of which line to stand in. This situation actually resemble the decision of different channel through which one sends information over a network. 

There are 3 strategies: 
1. Randomly choose a line: this depends largely on luck
2. Choose the shortest line: by the time you've done skimming, the situation may have changed
3. Randomly choose 2 lines then go for the shorter one: studied in (Mitzenmacher, The Power of Two Choices in Randomized Load Balancing, TPDS, 2001). This strategy is a hybridization of the first two and may be able to demonstrate both of them's advantages 

When you run the program, a window that demonstrates the lines and how many items each customer holds will show up. Each case has 1000 customers with the number of items ranging from 1 to 10 (illustrated by X). To run the first strategy, run RandomCustomerSimulation.java. To run the second strategy, run PickyCustomerSimulation.java. To run the thrid strategy, run Pick2CustomerSimulation.java





