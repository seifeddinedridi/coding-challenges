package dev.seifeddinedridi.codingchallenges;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[]{};
        } else if (prerequisites == null || prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }
        // 1. Build the graph
        // 2. Find all the courses with no dependencies
        // 3. Do topological sorting while storing the index of each visited course
        var graph = new ArrayList<List<Integer>>();
        var inverseGraph = new ArrayList<List<Integer>>();
        // Build the graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
            inverseGraph.add(new ArrayList<>());
        }
        for (var p : prerequisites) {
            // p[1] must be taken before taking p[0]
            graph.get(p[0]).add(p[1]);
            inverseGraph.get(p[1]).add(p[0]);
        }
        // Find all the elementary courses
        var elementaryCourses = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (graph.get(i).isEmpty()) {
                elementaryCourses.add(i);
            }
        }
        // Topological sorting
        int currentIndex = 0;
        var courses = new int[numCourses];
        while (!elementaryCourses.isEmpty()) {
            var course = elementaryCourses.poll();
            courses[currentIndex++] = course;
            // Find all the courses having "course" as a dependency
            for (var courseDep : inverseGraph.get(course)) {
                // If courseDep has no other dependency we can add
                // to elementaryCourses
                graph.get(courseDep).remove(course);
                if (graph.get(courseDep).isEmpty()) {
                    elementaryCourses.add(courseDep);
                }
            }
        }
        return currentIndex == numCourses ? courses : new int[]{};
    }
}