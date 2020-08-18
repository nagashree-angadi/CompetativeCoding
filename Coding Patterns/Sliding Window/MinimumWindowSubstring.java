/*
* Smallest Window containing Substring (hard) #
* Given a string and a pattern, find the smallest substring in the given
* string which has all the characters of the given pattern.
*/
import java.util.*;

class MinimumWindowSubstring {
    public static String findPermutation(String str, String pattern) {

        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int matched = 0;
        int length = str.length() + 1;
        int start = 0;
        int j=0;

        for(int i=0; i< pattern.length(); i++){
            char ch = pattern.charAt(i);
            count.put( ch, count.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i< str.length(); i++){
            char right = str.charAt(i);
            if(count.containsKey(right)){
                count.put(right, count.get(right)-1);
                if(count.get(right) >= 0)
                    matched++;
            }

            while(matched == pattern.length()){
                if( i-j+1 <= length) {
                    length = i - j + 1;
                    start = j;
                }

                char left = str.charAt(j);
                if(count.containsKey(left)) {
                    if(count.get(left) == 0)
                        matched--;
                    count.put(left, count.get(left) + 1);
                }
                j++;
            }
        }
        return (length > str.length())? "": str.substring(start, start+length);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findPermutation("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findPermutation("abdabca", "abc"));
        System.out.println(MinimumWindowSubstring.findPermutation("adcad", "abc"));
    }
}
