import java.lang.reflect.Array;

class Solution {
    public static void main(String[] args) {
        String first_word = "Flower";
        String second_word = "Flown";
        String third_word = "Flight";

        String[] strs = {first_word, second_word, third_word};

        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        // get the longest common prefix

        char[] first_word_chars = strs[0].toCharArray();
        char[] second_word_chars = strs[1].toCharArray();
        char[] third_word_chars = strs[2].toCharArray();

        char[][][] all_characters = {{first_word_chars}, {second_word_chars}, {third_word_chars}};

        int shortest_length = strs[0].length();
        for (int i = 1; i <= strs.length - 1; i++) {
            if (shortest_length > strs[i].length()) {
                shortest_length = strs[i].length();
            }
        }

        String result = "";

        for (int i = 0; i < shortest_length; i++) {
            int count = 0;
            for (int j = 0; j < strs.length - 1; j++) {
                if (all_characters[j][0][i] == all_characters[j + 1][0][i]) {
                    count++;
                } else {
                    return result;
                }
                if (count == strs.length - 1) {
                    result += (all_characters[j][0][i]);
                }
            }
        }
        return result;
    }
}