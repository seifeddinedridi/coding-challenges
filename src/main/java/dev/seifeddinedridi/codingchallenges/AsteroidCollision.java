package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayDeque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new ArrayDeque<Integer>();
        for (var asteroid : asteroids) {
            var add = true;
            while (add && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                var topAsteroid = stack.peek();
                if (topAsteroid <= -asteroid) {
                    // Collision
                    add = topAsteroid + asteroid != 0;
                    stack.pop();
                } else {
                    add = false;
                }
            }
            if (add) {
                stack.push(asteroid);
            }
        }
        var asteroidsPostCollision = new int[stack.size()];
        var index = stack.size() - 1;
        while (!stack.isEmpty()) {
            asteroidsPostCollision[index--] = stack.pop();
        }
        return asteroidsPostCollision;
    }
}
