package dev.seifeddinedridi.codingchallenges;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var visitedRooms = new HashSet<Integer>();
        canVisitAllRooms(rooms, visitedRooms, 0);
        return visitedRooms.size() == rooms.size();
    }

    private void canVisitAllRooms(List<List<Integer>> rooms, Set<Integer> visitedRooms, int currentRoom) {
        if (visitedRooms.contains(currentRoom)) {
            return;
        }
        visitedRooms.add(currentRoom);
        for (var nextRoom : rooms.get(currentRoom)) {
            canVisitAllRooms(rooms, visitedRooms, nextRoom);
        }
    }
}
