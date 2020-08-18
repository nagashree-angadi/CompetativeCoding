/*
Longest Substring with Same Letters after Replacement (hard)
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’
letters with any letter, find the length of the longest substring having the same letters after replacement.
*/
import java.util.*;
class CharacterReplacement {
    public static int findLength(String str, int k) {
        int j=0;
        int res = 0;
        int maxWindow = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0)+1);
            maxWindow = Math.max(maxWindow, count.get(ch));

            if( i-j+1 - maxWindow > k){
                char left = str.charAt(j);
                count.put(left, count.get(left)-1);
                j++;
            }

            res = Math.max( res, i-j+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
