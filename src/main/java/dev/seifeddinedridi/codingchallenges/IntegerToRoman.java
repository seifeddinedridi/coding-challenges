package dev.seifeddinedridi.codingchallenges;

public class IntegerToRoman {

    public String intToRoman(int num) {
        // 1. number is between 0 and 9 (I, V, X)
        // 2. number is between 10 and 90 (X, L, C)
        // 3. number is between 100 and 900 (X, L, C, D, M)
        // 4. number is between 1000 and 9000 (I, X, L, C, D, M)
        var sb = new StringBuilder();
        var divider = 1;
        while (num > 0) {
            int m = (num % 10) * divider;
            num /= 10;
            if (m <= 9) {
                sb.insert(0, convertSingleDigitToRoman(m));
            } else if (m <= 90) {
                sb.insert(0, convertDoubleDigitsToRoman(m));
            } else if (m <= 900) {
                sb.insert(0, convertTripleDigitsToRoman(m));
            } else if (m <= 9000) {
                sb.insert(0, convertQuadripleDigitsToRoman(m));
            }
            divider *= 10;
        }
        return sb.toString();
    }

    private String convertSingleDigitToRoman(int n) {
        return switch (n) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
    }

    private String convertDoubleDigitsToRoman(int n) {
        return switch (n) {
            case 10 -> "X";
            case 20 -> "XX";
            case 30 -> "XXX";
            case 40 -> "XL";
            case 50 -> "L";
            case 60 -> "LX";
            case 70 -> "LXX";
            case 80 -> "LXXX";
            case 90 -> "XC";
            default -> "";
        };
    }

    private String convertTripleDigitsToRoman(int n) {
        return switch (n) {
            case 100 -> "C";
            case 200 -> "CC";
            case 300 -> "CCC";
            case 400 -> "CD";
            case 500 -> "D";
            case 600 -> "DC";
            case 700 -> "DCC";
            case 800 -> "DCCC";
            case 900 -> "CM";
            default -> "";
        };
    }

    private String convertQuadripleDigitsToRoman(int n) {
        return switch (n) {
            case 1000 -> "M";
            case 2000 -> "MM";
            case 3000 -> "MMM";
            default -> "";
        };
    }
}
