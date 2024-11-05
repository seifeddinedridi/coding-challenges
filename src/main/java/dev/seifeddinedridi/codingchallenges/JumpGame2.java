package dev.seifeddinedridi.codingchallenges;

public class JumpGame2 {

    public int jump(int[] nums) {
        var startRange = 0;
        var endRange = nums[0];
        var jumpsCount = nums.length == 1 ? 0 : 1;
        while (endRange < nums.length - 1) {
            var expandedEnd = endRange;
            // Expand the current range at index
            for (int i = startRange; i <= Math.min(nums.length - 1, endRange); i++) {
                expandedEnd = Math.max(expandedEnd, i + nums[i]);
            }
            startRange = endRange + 1;
            endRange = expandedEnd;
            jumpsCount++;
        }
        return jumpsCount;
    }

     int bestJumpON2(int[] nums, int targetIndex, int[] cache) {
         if (targetIndex == 0) {
             return 0;
         }
         int ans = nums.length;
         for (int i = targetIndex - 1; i >= 0; i--) {
             if (i + nums[i] >= targetIndex) {
                 if (cache[i] == 0) {
                     cache[i] = 1 + bestJumpON2(nums, i, cache);
                 }
                 ans = Math.min(ans, cache[i]);
             }
         }
         return ans;
     }
}
