package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandomO1 {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;

    public InsertDeleteGetRandomO1() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        var res = !map.containsKey(val);
        if (res) {
            map.put(val, list.size());
            list.add(val);
        }
        return res;
    }

    public boolean remove(int val) {
        var res = map.containsKey(val);
        if (res) {
            var index = map.get(val);
            // Get the last value in the list
            var lastValue = list.getLast();
            // Swap of values
            list.set(index, lastValue);
            list.removeLast();
            this.map.put(lastValue, index);
            // Update indices in the map
            map.remove(val);
        }
        return res;
    }

    public int getRandom() {
        var i = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.get(i);
    }
}
