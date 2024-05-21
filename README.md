# Shipping-Company-Optimization
The MinimumContainers project provides a Java solution to determine the minimum number of containers needed to hold a set of shipments, given specific container capacities. This can be useful for logistics and inventory management where optimizing space and resources is critical.
Define the class and method:
Define MinimumContainers class.
Define minimumContainers method with parameters int[] shipments and int[] containerLimits.

Sort the shipments array:
Sort shipments array in ascending order using Arrays.sort().
Reverse the sorted array to get it in descending order.

Sort the container limits array:
Sort containerLimits array in ascending order using Arrays.sort().
Reverse the sorted array to get it in descending order.

Initialize variables:
Initialize containerIndex to 0.
Initialize containersUsed to 0.

Process each shipment:
Loop through each shipment in shipments.
Use a while loop to allocate each shipment to containers as long as there are shipments left and containers available.
Check if the current container can accommodate the shipment fully or partially.
Deduct the shipment amount from the container capacity.
Move to the next container if the current one is fully used.

Check for insufficient capacity:
If any shipment cannot be fully accommodated by the available containers, return -1.

Account for partially used containers:
If the last used container still has capacity, increment containersUsed.

Return the result:
Return the number of containers used.

Main method for testing:
Define the main method.
Initialize test arrays shipments and containerLimits.
Call minimumContainers with test arrays.
Print the result or a message indicating insufficient capacity.
