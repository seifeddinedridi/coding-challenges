package dev.seifeddinedridi.codingchallenges;

import java.util.HashSet;
import java.util.List;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        var forwardSearchQ = new HashSet<String>();
        forwardSearchQ.add(beginWord);
        var backwardSearchQ = new HashSet<String>();
        backwardSearchQ.add(endWord);
        int minSteps = 0;
        var visited = new HashSet<String>();
        while (!forwardSearchQ.isEmpty() && !backwardSearchQ.isEmpty()) {
            if (forwardSearchQ.size() > backwardSearchQ.size()) {
                var temp = forwardSearchQ;
                forwardSearchQ = backwardSearchQ;
                backwardSearchQ = temp;
            }
            var secondaryQueue = new HashSet<String>();
            for (var word : forwardSearchQ) {
                if (visited.add(word)) {
                    for (int i = 0; i < word.length(); i++) {
                        var wordArray = word.toCharArray();
                        for (var c = 'a'; c <= 'z'; c++) {
                            var cc = wordArray[i];
                            wordArray[i] = c;
                            var mutatedWord = new String(wordArray);
                            if (backwardSearchQ.contains(mutatedWord)) {
                                return minSteps + 2;
                            }
                            if (wordSet.contains(mutatedWord)) {
                                secondaryQueue.add(mutatedWord);
                            }
                            wordArray[i] = cc;
                        }
                    }
                }
            }
            forwardSearchQ = secondaryQueue;
            minSteps++;
        }
        return 0;
    }
}
