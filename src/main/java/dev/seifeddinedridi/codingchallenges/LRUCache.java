package dev.seifeddinedridi.codingchallenges;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private static final class CacheEntry {
        int key;
        int value;
        CacheEntry next;
        CacheEntry previous;

        CacheEntry(int key, int value, CacheEntry next, CacheEntry previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private final int capacity;
    private CacheEntry head;
    private CacheEntry tail;
    private final Map<Integer, CacheEntry> lruCache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruCache = new HashMap<>();
    }

    public int get(int key) {
        if (lruCache.containsKey(key)) {
            // Move node to the head of the linked list
            return replace(key, lruCache.get(key).value);
        }
        return -1;
    }

    private int replace(int key, int value) {
        var target = lruCache.get(key);
        if (head == target) {
            // Current is the head
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (tail == target) {
            tail = tail.previous;
            tail.next = null;
        } else {
            var previous = target.previous;
            var next = target.next;
            previous.next = next;
            if (next != null) {
                next.previous = previous;
            }
        }
        lruCache.remove(target.key);
        put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (lruCache.containsKey(key)) {
            // Update existing key
            replace(key, value);
        } else {
            if (lruCache.size() >= capacity) {
                lruCache.remove(tail.key);
                tail = tail.previous;
                if (tail != null) {
                    tail.next = null;
                }
            }
            // Head always points to the latest node
            var node = new CacheEntry(key, value, head, null);
            if (head != null) {
                head.previous = node;
            }
            head = node;
            if (tail == null) {
                tail = head;
            }
            lruCache.put(key, head);
        }
    }
}

class LRUCacheLinkedHashMap {

    private final Map<Integer, Integer> lruCache;

    public LRUCacheLinkedHashMap(int capacity) {
        this.lruCache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (lruCache.containsKey(key)) {
            return lruCache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        lruCache.put(key, value);
    }
}
