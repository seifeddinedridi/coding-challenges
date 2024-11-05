package dev.seifeddinedridi.codingchallenges;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        var totalGas = 0;
        var totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        var total = 0;
        var index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                index = i + 1;
            }
        }
        return index;
    }
}
