/*
* Words Concatenation (hard) #
* Given a string and a list of words, find all the starting indices of substrings in
* the given string that are a concatenation of all the given words exactly once
* without any overlapping of words. It is given that all words are of the same length.
* */
import java.util.*;

class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        List<Integer> res = new ArrayList<Integer>();
        int wordLength = words[0].length();

        for (int i = 0; i <= str.length() - words.length * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int next = i + j * wordLength;
                String word = str.substring(next, next + wordLength);
                if (!wordCount.containsKey(word))
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);
                if (wordsSeen.get(word) > wordCount.getOrDefault(word, 0))
                    break;

                if (j + 1 == words.length)
                    res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
