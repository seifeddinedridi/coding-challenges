package dev.seifeddinedridi.codingchallenges;

import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        var permutations = new ArrayList<List<Integer>>();
        permute(nums, 0, new ArrayList<>(), permutations, new HashSet<>());
        return permutations;
    }

    private void permute(int[] nums, int index, List<Integer> currentList, List<List<Integer>> permutations, Set<Integer> occupiedPositions) {
        if (index == nums.length) {
            permutations.add(new ArrayList<>(currentList));
        } else {
            // Insert current number at every possible index position
            var positions = IntStream.range(0, nums.length)
                .filter(p -> !occupiedPositions.contains(p))
                .toArray();
            for (var p : positions) {
                currentList.add(nums[p]);
                occupiedPositions.add(p);
                permute(nums, index + 1, currentList, permutations, occupiedPositions);
                occupiedPositions.remove(p);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}