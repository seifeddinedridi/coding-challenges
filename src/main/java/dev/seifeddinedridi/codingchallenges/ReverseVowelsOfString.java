package dev.seifeddinedridi.codingchallenges;

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int i = 0, j = a.length - 1;

        while (i < j) {
            while (i < j && !isVowel(a[i])) i++;
            while (i < j && !isVowel(a[j])) j--;

            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;

            i++;
            j--;
        }
        return new String(a);
    }

    private boolean isVowel(char c) {
        return switch (c) {
            case 'a','e','i','o','u','A','E','I','O','U' -> true;
            default -> false;
        };
    }
}
