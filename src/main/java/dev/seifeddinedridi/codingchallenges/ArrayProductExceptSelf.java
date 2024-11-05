package dev.seifeddinedridi.codingchallenges;

public class ArrayProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        var prefix = new int[nums.length];
        var suffix = new int[nums.length];
        var ans = new int[nums.length];
        for (var i = 0; i < nums.length; i++) {
            prefix[i] = i > 0 ? prefix[i - 1] : 1;
            prefix[i] *= nums[i];
            suffix[nums.length - 1 - i] = (nums.length - 1 - i < nums.length - 1 ? suffix[nums.length - i] : 1);
            suffix[nums.length - 1 - i] *= nums[nums.length - 1 - i];
        }
        for (var i = 0; i < nums.length; i++) {
            ans[i] = (i > 0 ? prefix[i - 1] : 1) * (i < nums.length - 1 ? suffix[i + 1] : 1);
        }
        return ans;
    }
}
