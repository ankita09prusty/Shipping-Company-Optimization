import java.util.Arrays;

public class MinimumContainers {

    public static int minimumContainers(int[] shipments, int[] containerLimits) {
        // Sort shipments in descending order
        Arrays.sort(shipments);
        for (int i = 0; i < shipments.length / 2; i++) {
            int temp = shipments[i];
            shipments[i] = shipments[shipments.length - i - 1];
            shipments[shipments.length - i - 1] = temp;
        }

        // Sort containers in descending order
        Arrays.sort(containerLimits);
        for (int i = 0; i < containerLimits.length / 2; i++) {
            int temp = containerLimits[i];
            containerLimits[i] = containerLimits[containerLimits.length - i - 1];
            containerLimits[containerLimits.length - i - 1] = temp;
        }

        int containerIndex = 0;
        int containersUsed = 0;

        for (int shipment : shipments) {
            while (shipment > 0 && containerIndex < containerLimits.length) {
                if (containerLimits[containerIndex] > 0) {
                    // If the current container can accommodate the shipment fully or partially
                    if (containerLimits[containerIndex] >= shipment) {
                        containerLimits[containerIndex] -= shipment;
                        shipment = 0;
                    } else {
                        shipment -= containerLimits[containerIndex];
                        containerLimits[containerIndex] = 0;
                    }
                }
                if (containerLimits[containerIndex] == 0) {
                    containerIndex++;
                    containersUsed++;
                }
            }
            if (shipment > 0) {
                return -1;
            }
        }


        if (containerIndex < containerLimits.length && containerLimits[containerIndex] > 0) {
            containersUsed++;
        }

        return containersUsed;
    }

    public static void main(String[] args) {
        int[] shipments = {10, 20, 30};
        int[] containerLimits = {15, 15, 20, 10};
        int minContainers = minimumContainers(shipments, containerLimits);

        if (minContainers == -1) {
            System.out.println("Insufficient container capacity");
        } else {
            System.out.println("Minimum number of containers needed: " + minContainers);
        }
    }
}