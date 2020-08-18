/*
* Permutation in a String (hard)
* Given a string and a pattern, find out if the string contains any permutation of the pattern.
* */
import java.util.*;

class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        int j=0;
        int matched = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for(char ch: pattern.toCharArray())
            count.put(ch, count.getOrDefault(ch, 0)+1);

        for(int i=0; i<str.length(); i++){
            char right = str.charAt(i);
            if(count.containsKey(right)){
                count.put(right, count.get(right)-1);
                if( count.get(right) == 0)
                    matched++;
            }

            if (matched == count.size())
                return true;

            if(i >= pattern.length()-1){
                char left = str.charAt(j);
                if(count.containsKey(left)) {
                    if( count.get(left) == 0)
                        matched--;
                    count.put(left, count.get(left)+1);
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }
}
