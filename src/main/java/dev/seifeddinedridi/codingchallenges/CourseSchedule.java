package dev.seifeddinedridi.codingchallenges;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        } else if (numCourses == 0) {
            return false;
        }
        var graph = new HashMap<Integer, List<Integer>>();
        var fundamentalCoursesReverseArray = new int[numCourses];
        for (var prerequisite : prerequisites) {
            if (!graph.containsKey(prerequisite[1])) {
                graph.put(prerequisite[1], new ArrayList<>());
            }
            graph.get(prerequisite[1]).add(prerequisite[0]);
            fundamentalCoursesReverseArray[prerequisite[0]]++;
        }
        // Set of all courses with no dependencies
        var fundamentalCourses = new LinkedList<Integer>();
        for (var i = 0; i < numCourses; i++) {
            if (fundamentalCoursesReverseArray[i] == 0) {
                fundamentalCourses.add(i);
            }
        }
        var finishedCourses = 0;
        while (!fundamentalCourses.isEmpty()) {
            var n = fundamentalCourses.poll();
            finishedCourses++;
            // Find all the nodes pointing towards n
            // where prerequisites[?][1] = n
            // For each node m that has an edges from n to m
            if (!graph.containsKey(n)) {
                continue;
            }
            for (var m : graph.get(n)) {
                if (fundamentalCoursesReverseArray[m] > 0) {
                    fundamentalCoursesReverseArray[m]--;
                    if (fundamentalCoursesReverseArray[m] == 0) {
                        fundamentalCourses.add(m);
                    }
                }
            }
        }
        return finishedCourses == numCourses;
    }
    
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        } else if (numCourses == 0) {
            return false;
        }
        var graph = new HashMap<Integer, List<Integer>>();
        for (var prerequisite : prerequisites) {
            if (!graph.containsKey(prerequisite[0])) {
                graph.put(prerequisite[0], new ArrayList<>());
            }
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        var visitedNodes = new HashSet<Integer>();
        var finishedCourses = new HashSet<Integer>();
        for (var nodeId : graph.keySet()) {
            if (!visit(graph, nodeId, visitedNodes, finishedCourses)) {
                return false;
            }
        }
        return true;
    }

    private boolean visit(Map<Integer, List<Integer>> graph, int nodeId,
                          Set<Integer> visitedNodes, Set<Integer> markedNodes) {
        if (markedNodes.contains(nodeId)) {
            return true;
        }
        if (visitedNodes.contains(nodeId)) {
            return false;
        }
        visitedNodes.add(nodeId);
        if (graph.containsKey(nodeId)) {
            for (var c : graph.get(nodeId)) {
                if (!visit(graph, c, visitedNodes, markedNodes)) {
                    return false;
                }
            }
        }
        markedNodes.add(nodeId);
        return true;
    }
}