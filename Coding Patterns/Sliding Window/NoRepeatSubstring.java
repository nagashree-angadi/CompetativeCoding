/*
* No-repeat Substring (hard)
* Given a string, find the length of the longest substring which has no repeating characters.
* */
import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String str) {
        int j=0;
        int res = 0;
        Map<Character, Integer> lastIndex = new HashMap<>();

        for( int i=0; i< str.length(); i++){
            char ch = str.charAt(i);

            if(lastIndex.containsKey(ch))
                j = Math.max( j, lastIndex.get(ch)+1);

            lastIndex.put(ch, i);
            res = Math.max( res, i-j+1);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
