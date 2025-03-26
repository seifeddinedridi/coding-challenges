package dev.seifeddinedridi.codingchallenges;

public class Candy {

    public int candy(int[] ratings) {
        var candies = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]
                    && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]
                    && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        var candiesCount = ratings.length;
        for (int candy : candies) {
            candiesCount += candy;
        }
        return candiesCount;
    }
}
