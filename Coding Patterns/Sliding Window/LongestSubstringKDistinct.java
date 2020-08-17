/*
* Longest Substring with K Distinct Characters (medium)
* Given a string, find the length of the longest substring in it with no more than K distinct characters.
* */
import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int res = 0;
        int j = 0;
        for( int i=0; i< str.length(); i++){
            char right = str.charAt(i);
            count.put( right, count.getOrDefault(right, 0)+1);

            while( count.size() > k){
                char left = str.charAt(j);
                count.put(left, count.get(left)-1);
                if( count.get(left) == 0)
                    count.remove(left);
                j++;
            }

            res = Math.max( res, i-j+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring for araaci: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring for araaci: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring for cbbebi: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
