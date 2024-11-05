package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/minimum-genetic-mutation

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // For each gene we have a fixed number of mutations in order for the gene
        // to become endGene
        // So the approach is to loop over the characters and mutate one by one
        // For new mutation check if the gene is in the bank
        // If not, ignore the mutation ele continue to the next character
        // If mutation is equal to endGene then return the number of mutations
        // This is alike BFS (breath-first search) where the nodes represent strings
        // And the edges are 4 which correspond to all possible characters
        var queue = new LinkedList<String>();
        queue.add(startGene);
        int mutationsCount = 0;
        var bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        var mutationsSet = new HashSet<String>();
        while (!queue.isEmpty()) {
            // We have to empty out the queue
            var secondaryQueue = new LinkedList<String>();
            while (!queue.isEmpty()) {
                var gene = queue.pop();
                if (gene.equals(endGene)) {
                    return mutationsCount;
                }
                if (mutationsSet.contains(gene)) {
                    continue;
                }
                mutationsSet.add(gene);
                for (int i = 0; i < gene.length(); i++) {
                    // Each character can become any of the possible 4 mutations
                    for (char c : new char[]{'A', 'C', 'G', 'T'}) {
                        String geneCopy;
                        if (i > 0 && i < gene.length() - 1) {
                            geneCopy = gene.substring(0, i) + c + gene.substring(i + 1);
                        } else if (i > 0) {
                            geneCopy = gene.substring(0, i) + c;
                        } else {
                            geneCopy = c + gene.substring(i + 1);
                        }
                        if (bankSet.contains(geneCopy)) {
                            secondaryQueue.add(geneCopy);
                        }
                    }
                }
            }
            queue.addAll(secondaryQueue);
            mutationsCount++;
        }
        return -1;
    }
}