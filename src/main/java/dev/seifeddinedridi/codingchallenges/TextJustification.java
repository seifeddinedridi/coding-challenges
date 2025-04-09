package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        var lines = new ArrayList<String>();
        var cursor = 0;
        while (cursor < words.length) {
            var totalWordsLength = 0;
            var currentWords = new ArrayList<String>();
            while (cursor < words.length) {
                if (totalWordsLength + currentWords.size()
                        + words[cursor].length() > maxWidth) {
                    break;
                }
                currentWords.add(words[cursor]);
                totalWordsLength += words[cursor++].length();
            }
            var sb = new StringBuilder();
            if (cursor == words.length || currentWords.size() == 1) {
                sb.append(String.join(" ", currentWords));
                var nbSpaces = maxWidth - sb.length();
                sb.append(" ".repeat(nbSpaces));
            } else {
                var inbetweenSpaces = new int[currentWords.size() - 1];
                var nbSpaces = maxWidth - totalWordsLength;
                for (int i = 0; i < nbSpaces; i++) {
                    var index = i % inbetweenSpaces.length;
                    inbetweenSpaces[index]++;
                }
                for (int i = 0; i < inbetweenSpaces.length; i++) {
                    sb.append(currentWords.get(i));
                    sb.append(" ".repeat(inbetweenSpaces[i]));
                }
                sb.append(currentWords.get(currentWords.size() - 1));
            }
            lines.add(sb.toString());
        }
        return lines;
    }
}
